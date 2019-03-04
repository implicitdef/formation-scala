const fs = require('fs')
const cheerio = require('cheerio')

const htmlFile = __dirname + '/existing/index.html'
const content = fs.readFileSync(htmlFile, 'utf8')

const $ = cheerio.load(content)

console.log('-------')

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

$('.slides > section').each((sectionIndex, section) => {
  if (sectionIndex === 18) {
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
          .find('h1, h2, h3, h4, h5, h6, code, p')
          .filter(notEmpty)
          .each((_, e) => {
            console.log(`   ==> ${e.tagName}`, shortenTextForPrint(e))
          })
      })
  }
})

// files.forEach(function(file) {
//   var contents = fs.readFileSync(__dirname + '/files/' + file, 'utf8')
//   console.log(contents)
// })
