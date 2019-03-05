const fs = require('fs')
const path = require('path')
const cheerio = require('cheerio')

console.log('-------')
const MARKDOWN_FILE = path.resolve(__dirname, '../slides/slides.md')
const HTML_FILE = __dirname + '/existing/index.html'
const content = fs.readFileSync(HTML_FILE, 'utf8')
const $ = cheerio.load(content)

function printSummary(node) {
  console.log(shortenTextForPrint(node))
}

function shortenTextForPrint(node) {
  return (
    $(node)
      .text()
      .slice(0, 100)
      .replace(/\s+/g, ' ') + '...'
  )
}

function notEmpty(_, node) {
  return (
    $(node)
      .text()
      .trim() !== ''
  )
}

function prependToEachLine(prefix, str) {
  return str
    .split('\n')
    .map(_ => prefix + _)
    .join('\n')
}

function removeNumberAtStart(str) {
  return str.replace(/^\d\.\s?/, '')
}

function clearMarkdownFile() {
  fs.writeFileSync(MARKDOWN_FILE, '')
}

function printToMarkdownFile(content) {
  fs.appendFileSync(MARKDOWN_FILE, content + '\n\n')
}

function runParsing() {
  clearMarkdownFile()
  $('.slides > section').each((sectionIndex, section) => {
    //if (sectionIndex === 18) {
    console.log(
      `Section ${sectionIndex}, nb slides = ${
        $(section).find('section').length
      }`
    )
    printSummary(section)
    $(section)
      .find('section')
      .each((slideIndex, slide) => {
        console.log(`Slide ${slideIndex}`)
        $(slide)
          .find('h1, h3, code, p')
          .filter(notEmpty)
          .each((_, e) => {
            console.log(`   ==> ${e.tagName}`, shortenTextForPrint(e))
            switch (e.tagName) {
              case 'h1':
                printToMarkdownFile(prependToEachLine('# ', $(e).text()))
                break
              case 'h3':
                printToMarkdownFile(prependToEachLine('### ', $(e).text()))
                break
              case 'code':
                printToMarkdownFile(prependToEachLine('    ', $(e).text()))
                break
              case 'p':
                printToMarkdownFile(removeNumberAtStart($(e).text()))
                break
            }
          })
        // slides separator
        printToMarkdownFile('---')
      })
    // sections separator
    printToMarkdownFile('===')
    //}
  })
  console.log('Parsing finished')
}

runParsing()
