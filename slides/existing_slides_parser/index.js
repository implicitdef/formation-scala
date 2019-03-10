const fs = require('fs')
const path = require('path')
const cheerio = require('cheerio')

console.log('-------')
const MARKDOWN_FILE = path.resolve(__dirname, './generated_slides.md')
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
    node.tagName === 'img' ||
    $(node)
      .text()
      .trim() !== ''
  )
}

function prependToEachLine(
  prefix,
  str,
  { trimEachLine, removeEmptyLines } = {}
) {
  return str
    .split('\n')
    .map(_ => (trimEachLine ? _.trim() : _))
    .filter(_ => !(removeEmptyLines && _ == ''))
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
  lastPrinted = content
  fs.appendFileSync(MARKDOWN_FILE, content)
}

function runParsing() {
  clearMarkdownFile()
  const sectionsStrs = $('.slides > section')
    // .filter((sectionIndex, section) => sectionIndex === 1)
    .map((sectionIndex, section) => {
      console.log(
        `Section ${sectionIndex}, nb slides = ${
          $(section).find('section').length
        }`
      )
      if (sectionIndex === 0) {
        return '# Scala'
      }
      const slidesStrs = $(section)
        .find('section')
        // .filter(slideIndex => slideIndex === 0)
        .map((slideIndex, slide) => {
          console.log(
            `Slide ${slideIndex}, imgs = `,
            $(slide).find('img').length
          )
          const elements = $(slide)
            .find('h1, h3, code, p, ul, img')
            .filter(notEmpty)
            .map((_, e) => {
              console.log(`   ==> ${e.tagName}`, shortenTextForPrint(e))
              switch (e.tagName) {
                case 'h1':
                  return prependToEachLine('# ', $(e).text())
                case 'h3':
                  return prependToEachLine('### ', $(e).text())
                case 'code':
                  return prependToEachLine('    ', $(e).text())
                case 'p':
                  return removeNumberAtStart($(e).text())
                case 'ul':
                  const trimmed = $(e).text()
                  return prependToEachLine('- ', trimmed, {
                    trimEachLine: true,
                    removeEmptyLines: true
                  })
                case 'img':
                  return `<img src="${$(e).attr('data-src')}"/>`
              }
            })
          return elements.get().join('\n\n')
        })
      return slidesStrs.get().join('\n\n----\n\n')
    })
  const final = sectionsStrs.get().join('\n\n===\n\n')
  printToMarkdownFile(final)
  console.log('Parsing finished')
}

runParsing()
