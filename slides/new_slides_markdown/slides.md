# Scala

===

# PRESENTATION

---

# MOI

Emmanuel Letallieur

Développeur freelance Scala - React/Redux/Node

emmanuel@implicitdef.com

www.implicitdef.com

---

# VOUS ?

---

### SCALA c'est quoi ?

Un language de programmation, avec une librairie standard

Compile vers la JVM

Multiparadigme : orienté objet et fonctionnel

---

### Pour faire quoi ?

- du backend :
  - webapps
  - webservices
  - site webs
  - batchs
  - traitement Big Data
  - etc.
- éventuellement du front avec Scala.js

---

### AVANTAGES

- La JVM : tourne partout
- Accès à l'écosystème Java
- Performant
- Typage très poussé, permet de détecter 99% des erreurs de code
- fonctionnel
- plein de features developer-friendly
- pragmatique
- a du succès en entreprise

---

### INCONVENIENTS

- Lourd (temps de compilation, IDE)
- Complexe
- Plusieurs manières d'écrire la même chose
- Un iceberg : presque impossible de connaitre toutes les features
- Culture de la complexité dans la communauté
- Adoption limitée
- Trouver des développeurs

===

# PREMIERS PAS

---

### REPL

    $ scala
    Welcome to Scala 2.12.1 (Java HotSpot(TM) 64-Bit Server VM, Java 1.8.0_65).
    Type in expressions for evaluation. Or try :help.

    scala> val foo = "Bar"
    foo: String = Bar

    scala> println(foo)
    Bar

    scala>

---

### scalafiddle.io

<img src="scala/e9df0a63e77f7000d2677e28f94f263d.png"/>

---

### Execution d'un Script .Scala

    // dans index.scala

    println("Hello world")

    $ scala index.scala
    Hello

---

### CRéER un PROJET SBT

    $ sbt new sbt/scala-seed.g8

    A minimal Scala project.

    name [Scala Seed Project]: hello-world

    Template applied in ./hello-world

    hello-world
    ├── build.sbt                 // configuration du build sbt
    ├── project                   // fichiers additionnels utilisés par sbt
    └── src
        ├── main
        |   └── resources         // fichiers à inclure dans le JAR final
        │   └── scala             // code Scala de l'application
        │       └── example
        │           └── Hello.scala
        └── test
            └── resources         // fichiers à inclure dans le JAR de test
            └── scala             // code Scala de test
    └── target                    // auto-généré, contient les fichiers compilés

La structure des fichiers est toujours la même :

---

### ExEmples de Build.sbt

    // build.sbt
    name := "hello-world"

    version := "1.0"

    scalaVersion := "2.12.3"

    libraryDependencies += "org.apache.derby" % "derby" % "10.4.1.3"



    // ou aussi
    import Dependencies._

    lazy val root = (project in file(".")).
      settings(
        inThisBuild(List(
          organization := "com.example",
          scalaVersion := "2.12.3",
          version      := "1.0"
        )),
        name := "Hello",
        libraryDependencies += "org.apache.derby" % "derby" % "10.4.1.3"
      )

---

### COmmandes SBT

    $ sbt compile
    $ sbt run
    $ sbt test




    $ sbt
    > compile

    > run

    > reload

    > ~compile

===

# STRUCTURE DES FICHIERS

---

### TOp-level definitions

    // package courant
    package foo.bar;

    // imports
    import (...);

    // déclarations de classes et d'objects
    class Foo {
        (...)
    }

    object Bar {
        (...)
    }

---

### NOMMAGE des fichiers

    // dans MyClass.scala

    class MyClass {

        (...)

    }

Libre, mais fortement recommandé :

- un object ou class par fichier
- [name of the object/class].scala

---

### PACKAGING

    // dans src/main/scala/com/example/stuff/MyClass.scala

    package com.example.stuff;

    class MyClass {

        (...)

    }

Fortement recommandé : un dossier = un package

---

### POINT D'ENTREE

    // dans n'importe quel package
    // avec n'importe quel nom d'object

    object MyMainObject {

        // avec cette signature exacte !
        def main(args: Array[String]): Unit =
            (...)

    }

Imite le public static void main de Java

===

# VAL, VAR, DEF

---

### var, val

    var answer = 40
    answer = 42
    println(answer) //42



    val answer = 40
    println(answer) //40
    answer = 42 // NE COMPILE PAS "reassignement to val"

---

### def

    def sayHello(): Unit = {
        println("Hello world")
    }

    def sayHello2(who: String): Unit = {
        println("Hello " + who)
    }

    def sayHello3: Unit = {
        println("Hello world")
    }

    def sayHello4() = {
        println("Hello world")
    }

    def sayHello5 = {
        println("Hello world")
    }

    def sayHello6 =
        println("Hello world")

    def sayHello7 = println("Hello world")

---

### Appeler les méthodes

    sayHello() // Hello world
    sayHello2("world") // Hello world
    sayHello3 // Hello world

Convention : mettre () quand il y a des side-effects

---

### NOMMAGES AUTORISEs

    // alpha numérique et underscores
    val simple_Name123 = 1

    // caractères d'opérateurs
    val !#%&*+-/:<=>?@\^|~ = 1

    // mixer les deux avec un underscore
    val wordEndingInOpChars_!#%&*+-/:<=>?@\^|~ = 1

    // unicode
    val êtreOuNePasêtre = 1
    val © = 1

===

# IF, ELSE, WHILE, FOR

---

### IF, ELSE

    def sayHello = {
        if (1 + 1 == 2) {
            println("Hello world")
        }
    }

    def sayHello2 = {
        if (1 + 1 == 2) {
            println("Hello world")
        } else {
            println("Goodbye world")
        }
    }

    def sayHello3 = {
        if (1 + 1 == 2)
            println("Hello world")
        else
            println("Goodbye world")
    }

    def sayHello4 = {
        if (1 + 1 == 2)
            println("Hello world")
        else if (1 + 1 == 3)
            println("See you world")
        else
            println("Goodbye world")
    }

---

### IF/ELSE

    val message = if (1 + 1 == 2) "Goodbye" else "World"

if/else retourne toujours une valeur

Pas besoin de l'opérateur ternaire en Scala !

---

### WHILE, DO WHILE

    var n = 1
    while (n < 10) {
      println("Hello world " + n)
      n += 1
    }

    do {
      println("Hello world " + i)
      i += 1
    }
    while(i < 10);

---

### for

    for (i <- 1 to 10) {
        println("Hello world " + i)
    }

    // peut retourner une variable aussi, avec yield
    val messages = for (i <- 1 to 10) yield ("Hello world " + i)

    // peut boucler sur n'importe quelle collection
    for (message <- messages) {
        println(message)
    }

    // peut boucler sur plusieurs collections à la fois
    for {
        message <- messages
        i <- 1 to 3
    } {
        println(message)
    }

Le for classique des autres languages :

for (initialize; test; update)

n'existe pas en Scala

Le for de Scala permet d'itérer sur des collections

===

# EVERYTHING IS AN EXPRESSION

---

### RETURN

    def getMessage = {
        val who = "World"
        return "Hello " + world
    }

    def getMessage2 = {
        val who = "World"
        "Hello " + world
    }

    def getMessage3 =
        "Hello world"

    def getMessage4 = "Hello world"

    def add(a: Int, b: Int) = a + b

return est optionnel dans une fonction

La dernière expression est toujours retournée

---

### Points virgules

    def getMessage = {
        val who = "World";
        return "Hello " + world;
    }

; peut être mis à la fin de chaque instruction, optionnellement

---

### Parentheses et ACcolades

    // corps d'une fonction
    def getMessage = {
        "Hello world"
    }
    def getMessage2 = (
        "Hello world"
    )

    // appel d'une fonction
    println(add(1, 2)) //3
    println(add{1, 2}) //3
    println {
        "Hello world"
    }

() et {} sont interchangeables 90% du temps

Usage recommandé : () quand sur une seule ligne, {} quand on passe sur plusieurs lignes

---

### EXPRESSIONS

an "expression" is a combination of values and functions that are combined and interpreted by the compiler to create a new value

a "statement" is just a standalone unit of execution and doesn't return anything

En Scala, tout est une expression !

---

### EXPRESSIONS

    val message = "Hello World"

    val message2 = if (1 != 2) "Hello world" else "Goodbye world"

    val message3 = (for (i <- 1 to 13) yield ("Hello number " + i)).mkString(", ")

    val message4 = {
        val start = "Hello"
        val end = if (1 == 1) "World" else "you"
        start + " " + end
    }

    val message5 = {
        println("Building message5 value")
        "Hello world"
    }

    println {
        val start = "Hello"
        val end = if (1 == 1) "World" else "you"
        start + " " + end
    }

===

# LAzy VAL

---

### VAL vs DEF

    val answer = 10 * 4 + 2

    def otherAnswer = 10 * 4 + 2


    println(answer) //42
    println(otherAnswer) //42

Finalement, quelle différence entre une val et une def sans paramètres ?

---

### VAL vs DEF

    val answer = {
        println("building the val")
        10 * 4 + 2
    }

    def otherAnswer = {
        println("running the method")
        10 * 4 + 2
    }


    println(answer)
    println(answer)
    println(otherAnswer)
    println(otherAnswer)

    // building the val
    // 42
    // 42
    // running the method
    // 42
    // running the method
    // 42

val est évaluée une fois quand elle est instanciée

def est réevaluée à chaque fois

---

### Lazy Val

    lazy val answer = {
        println("building the lazy val")
        10 * 4 + 2
    }

    lazy val neverEvaluated = {
        println("This is not evaluated if you don't use it")
        10 * 4 + 2
    }

    println(answer)
    println(answer)
    // building the lazy val
    // 42
    // 42

lazy val est évaluée uniquement la première fois qu'elle est appelée

===

# Méthodes ou opérateurs ?

---

### Opérateurs

    10 + 3

    5 * 4

    "Hello " + "world"

    1 == 2

    Seq(1, 2, 3) ++ Seq(4, 5, 6)

Il n'y a pas d'opérateurs à proprement parler en Scala

Ce sont des méthodes définies sur les types

<img src="scala/05f69040f7a40c2a186a796139f3dbc3.png"/>

---

### INFIX Notation

    10.+(3)

    5.*(4)

    "Hello ".+("world")

    1.==(2)

    Seq(1, 2, 3).++(Seq(4, 5, 6))

Un appel de méthode avec un argument

On aurait pu aussi écrire

    a.method(b)

Peut s'écrire

    a method b

---

### Précédences des "Opérateurs"

    (all letters)
    |
    ^
    &
    < >
    = !
    :
    + -
    * / %
    (all other special characters)

Comment est-on sûr que l'expression suivante est bien interprétée dans le bon ordre ?

La précédence en Scala est décidée par le premier caractère de chaque méthode :

    a + b * c

---

### Unary functions

    myBoolean.unary_!

Revient à écrire

    !myBoolean

---

### Right ASSOCIATIVITY

Si une méthode est utilisée dans la notation affixe a method b :

- la méthode est invoquée sur l'expression de gauche : a.method(b)
- sauf si le nom de la méthode termine avec :, auquel cas ce sera b.method(a)

  1 :: myList
  // revient à appeler
  myList.::(1)

  // Usage typique
  1 :: 2 :: 3 :: Nil

===

# Typage ET INFérence

---

### INFéRENCE de Types

    // explicite
    val answer: Int = 42
    val message: String = "Hello world"

    // inféré
    val answer = 42
    val message = "Hello world"

Toute variable a un type

Mais peut être très souvent inféré par le compilateur

---

### INFéRENCE de Types

    def add(a: Int, b: Int): Int =
        a + b

    def add(a: Int, b: Int) =
        a + b

Même chose pour les fonctions

Dans la pratique : où mettre les types ? où les omettre ?

===

# IMPORTS

---

### IMPORTS : Syntaxes

    import scala.util.Random

    val foo = Random.nextInt()

    import scala.util.Random.nextInt

    val foo = nextInt()

    import scala.util.{Random, Either}

    val foo = Random.nextInt()

    import scala.util._

    val foo = Random.nextInt()

    import scala.util.Random._

    val foo = nextInt()

Quelle syntaxe utiliser ?

---

### Imports Local

    def generateSomeRandomNumbers = {
        import scala.util.Random._
        Seq(nextInt(), nextInt(), nextInt())
    }

Un import n'est pas forcément au début du fichier

===

# Nester les déclarations

---

### val dans une def

    def sayHello = {
        val start = "Hello"
        val end = "world"
        println(start + " " + world)
    }

---

### DEF dans une def

    def sayHello = {
        def sayHelloTo(name: String) =
            println("Hello " + name)

        sayHello("Sonia")
        sayHello("Fred")
        sayHello("Bill")

    }

---

### CLASS dans un object/class

    object MyObject {

        class SomeLocalClass {
            (...)
        }

        (...)

    }

    class MyClass {

        class SomeLocalClass {
            (...)
        }

        (...)

    }

---

### CLASS DANS UNE DEF

    def sayHello = {
        class SomeClassLocalToThisMethod {
            (...)
        }

        new SomeClassLocalToThisMethod

    }

et ainsi de suite...

---

### BONNES PRATIQUES

Lisibilité avant tout !

- val OK partout
- def dans des def parfois, avec parcimonie
- object OK pour mettre n'importe quoi dedans (sert de namespace)

===

# HIGHER ORDER FUNCTIONS

---

### HIGHER ORDER QUOI ?

higher-order function = Une fonction qui prend en paramètre (ou retourne) une fonction

    def sayHello(name: String, transformationFunction: String => String) = {
        val initialMessage = "Hello " + name
        val finalMessage = transformationFunction(initialMessage)
        println(finalMessage)
    }


    // usage en passant une def

    def makeUppercase(s: String): String =
        s.toUpperCase


    sayHello("Phil", makeUppercase) // HELLO PHIL


    // usage en passant une fonction anonyme

    sayHello("Lulu", s => s.toLowerCase) // hello lulu

---

### Types des fonctions

    String => String

    (Int, Int) => String

    () => Boolean

    (Boolean, Int, String) => Unit

    // etc.

---

### Declarer une fonction anonyme

    (name: String, score: String) => {
        println("Hello " + name + ", your score is " + score)
    }

    (name: String, score: String) => println("Hello " + name + ", your score is " + score)


    (name, score) => println("Hello " + name + ", your score is " + score)


    name => name.toUpperCase

---

### LA STOCKER

    val makeUpperCase = (name: String) => {
        name.toUpperCase
    }

    def makeUpperCase(name: String) = {
        name.toUpperCase
    }

Revient (presque !) à écrire une def

---

### Une SYNTAXE ENCORE PLUS COURTE ?

    sayHello("Lulu", s => s.toLowerCase) // hello lulu

    // encore plus court
    sayHello("Lulu", _.toLowerCase) // hello lulu


    // Autre exemple
    someSortingFunction(Seq("Max", "Phil", "Jo"), (a, b) => a.length < b.length)
    someSortingFunction(Seq("Max", "Phil", "Jo"), _.length < _.length)

===

# METHOD ARGUMENTS

---

### VALEURS PAR DEFAUT

    def saySomething(name: String, word: String = "Hello") = {
        println(word + " " + name)
    }

    saySomething("Momo") // Hello Momo
    saySomething("Lulu", "Goodbye") // Goodbye Lulu


    // Même pour des fonctions !
    def sayHello(name: String, transformationFunction: String => String = s => s) = {
        val initialMessage = "Hello " + name
        val finalMessage = transformationFunction(initialMessage)
        println(finalMessage)
    }

Syntaxe complète :

[nom]: [type] = [valeur par défaut]

---

### NAMED PARAMETERS

    def saySomething(name: String = "Max", word: String = "Hello") = {
        println(word + " " + name)
    }


    saySomething("Fred", "Goodbye")
    saySomething(name = "Fred", "Goodbye")

    // switchons l'ordre
    saySomething(word = "Goodbye", name = "Fred")

    // permet de jouer avec les valeurs par défaut sans respecter l'ordre
    saySomething(word = "Goodbye")

Bonne pratique : à utiliser quand beaucoup de types similaires, et toujours pour les booléens

    doRequest("www.example.com", useSsl = true)

---

### CALL-BY-NAME vs CALL-BY-VALUE

    def something() = {
      println("calling something")
      1 // return value
    }


    def callByValue(x: Int) = {
      println("x1=" + x)
      println("x2=" + x)
    }

    def callByName(x: => Int) = {
      println("x1=" + x)
      println("x2=" + x)
    }


    callByValue(something())
    // calling something
    // x1=1
    // x2=1

    callByName(something())
    // calling something
    // x1=1
    // calling something
    // x2=1

===

# Types (les bases)

---

### Types "Primitifs"

- String
- Char
- Boolean
- Int
- Double
- Float
- Long
- Short
- Byte

En Scala ce sont des types comme les autres !

Sauf que le compilateur les optimise pour cibler les primitives Java

---

### Hierarchie des types

<img src="scala/39a09f805bf7696b0b9303275c2d3b7e.png"/>

---

### Hierarchie des types

- ​Any au-dessus de tout
- AnyVal pour les types "primitifs"
- AnyRef pour les classes/objects
- Unit pour les méthodes qui ne retournent rien
- Null est le type de la valeur null
- Nothing pour les méthodes qui ne retournent pas

===

# CLASSES

---

### DEFINITION et usage

    class Foo {

        val variable1 = ...

        def method1 = ...

        def method2 = ...


    }


    val foo = new Foo
    println(foo.variable1)
    foo.method1()
    foo.method2()

---

### LE CORPS DE LA CLASSE EST éVALUé QUand instancié

    class Foo {

        println("This is evaluated every time you instantiate the class")

        val variable1 = ...

        def method1 = ...

        def method2 = ...


    }


    val foo = new Foo
    // This is evaluated every time you instantiate the class
    val foo2 = new Foo
    // This is evaluated every time you instantiate the class

---

### CONSTRUCTEUR

    class Foo(name: String) {

        // name peut-être utilisé partout dans la classe !

        val message = "Hello " + name

        def printTheName = println(name)

    }

    new Foo("Charles")

---

### CONSTRUCTEUR AVEC VAL

    // name devient une val de la classe, donc accessible depuis l'extérieur
    class Foo(val name: String) {

       ...

    }

    val foo = new Foo("Charles")
    println(foo.name) // Charles



    // strictement équivalent à
    class Foo(_name: String){
        val name = _name
    }

---

### AUXILARY CONSTRUCTORS

    class Foo(name: String, score: Int) {

       def this(name: String) =
         this(name, 0)

       def this(score: Int) =
         this("Max", score)

    }

Un auxiliary constructor doit toujours appeler le primary constructor : le point d'entrée reste unique

Peu utilisé puisqu'on a les valeurs par défaut et les named parameters, et les factory functions dans le companion object

---

### Visibilité

    class Foo {


       // public
       val a = ...

       // cette classe uniquement
       private b = ...

       // cette classe et ses sous-classes
       protected c = ...

       // uniquement pour un package précis
       private[some.package] d = ...

       // uniquement pour cette instance de cette classe
       private[this] e = ...

    }

===

# OBJECTS

---

### KEZAKO ?

    object Foo {

        val variable1 = ...

        def method1 = ...

        def method2 = ...

    }


    println(Foo.variable1)
    Foo.method1()
    Foo.method2()

object = un singleton

Une seule instance, automatique

Pas possible de l'instancier (pas de new)

---

### Usage

    object Configuration {

        val variable1 = ...
        val variable2 = ...
    }

    object EncodingUtils {

        def urlEncode(s: String) = ...

    }


    object Models {

        case class User( ... )
        case class Order( ... )
        case class Product( ... )

    }

organiser le code

---

### Usage

    object Directions {


        object South
        object West
        ...


    }

représenter une valeur unique

---

    class Foo {

        ...

    }

    object Foo {

        ...

    }

- même nom
- même fichier
- accès aux champs private de la classe
- utilisé généralement pour définir des méthodes liées à la classe : factory methods

companions objects

### USAGE

---

### USAGE

    // dans src/main/scala/com/example/mypackage
    package com.example


    package object mypackage {

        // Tout ce qui est défini dans cet object
        // est importé implicitement dans les autres fichiers
        // du même package

        // Peu également être utilisé ailleurs
        // en faisant un import sur le package
        // import com.example.mypackage._

        def something = ...

    }

package objects

===

# Héritage

---

### Classes Abstraites

    abstract class Greeter(name: String) {

      // non implémenté
      // les sous-classes doivent l'implémenter ou
      // être abstraites elles-mêmes
      protected def transformMessage(m: String): String

      // méthode normale
      def sayHello =
        println(transformMessage("Hello, I'm " + name))

    }

    class LoudGreeter(name: String) extends Greeter(name) {

      // le "override" est optionnel
      // s'il est présent, le compilateur vérifiera que c'est
      // bien une implémentation ou une surcharge
      override protected def transformMessage(m: String): String =
        m.toUpperCase + "!!!"
    }

    class QuietGreeter(name: String) extends Greeter(name) {

      override protected def transformMessage(m: String): String =
        m.toLowerCase.capitalize + "..."
    }

    new LoudGreeter("Marcel").sayHello
    // HELLO, I'M MARCEL!!!
    new QuietGreeter("Freddy").sayHello
    // Hello, i'm freddy...

---

### Trait

    // un trait n'a pas de paramètre de constructeur
    trait Greeter {

      val name: String

      protected def transformMessage(m: String): String

      def sayHello =
        println(transformMessage("Hello, I'm " + name))

    }

    class LoudGreeter(val name: String) extends Greeter {

      override protected def transformMessage(m: String): String =
        m.toUpperCase + "!!!"
    }

    class QuietGreeter(val name: String) extends Greeter {

      override protected def transformMessage(m: String): String =
        m.toLowerCase.capitalize + "..."
    }

    new LoudGreeter("Marcel").sayHello
    // HELLO, I'M MARCEL!!!
    new QuietGreeter("Freddy").sayHello
    // Hello, i'm freddy...

---

### Heriter plusieurs CHOSES A LA FOIS

    class Foo extends MyAbstractClass { ... }

    class Foo extends MyAbstractClass with MyTrait1 { ... }

    class Foo extends MyAbstractClass with MyTrait1, MyTrait2, MyTrait3 { ... }

    class Foo extends MyTrait1 { ... }

    class Foo extends MyTrait1 with MyTrait2, MyTrait3 { ... }

Comment le diamond problem est-il géré ?

---

### Trait vs Classes abstraites

- Une classe peut étendre une seule classe abstraite, mais plusieurs traits
- Seule une classe abstraite peut avoir des paramètres de constructeur

---

### Jouer avec le NEW

    trait TraitA { ... }
    trait TraitB { ... }
    class MyClass extends TraitA { ... }

    // instantiation simple
    val c = new MyClass

    // surcharge ou ajout de méthodes à la volée
    val c = new MyClass {
        ...
    }

    // ajout d'un trait
    val c = new MyClass with TraitB

    // instantiation directe d'un trait
    // possible uniquement si ne contient pas de méthodes abstraites
    val c = new TraitB

    // sinon il faut les implémenter
    val c = new TraitB {
        ...
    }

    // etc.

---

### Inheritance ou COMposition ?

    // héritage
    trait C {
        ...
    }
    class A extends C {
        ...
    }
    class B extends C {
        ...
    }


    // composition
    class C {
        ...
    }
    class A(c: C) {
        ...
    }
    class B(c: C) {
        ...
    }

Soit deux classes A et B qui ont besoin de partager du code dans C

===

# CASE CLASSES

---

### DEFINITION

    case class Foo(name: String, score: Int) {
        ...
    }

---

### CARACTERISTIQUES

    case class Foo(name: String, score: Int)

    val foo = Foo("Max", 50)

pas besoin du new pour les instancier

Fonctionne en définissant la méthode apply sur le companion object

---

### CARACTERISTIQUES

    case class Foo(name: String, score: Int)

    val foo = Foo("Max", 50)

    println(foo.name) // Max

les paramètres deviennent public par défaut, comme s'ils étaient définis avec val

---

### CARACTERISTIQUES

    case class Foo(name: String, score: Int)

    println(Foo("Max", 50) == Foo("Max", 50)) // true

    println(Foo("Max", 20) == Foo("Max", 80)) // false

    println(Foo("Max", 40)) // Foo(Max,40)

Implémente automatiquement les méthodes equals, hashCode, toString basées sur les paramètres

---

### CARACTERISTIQUES

    case class Foo(name: String, score: Int)

    val foo = Foo("Max", 50)

    println(foo.copy) // Foo(Max,50)
    println(foo.copy(name = "Fred")) // Foo(Fred,50)
    println(foo.copy(score = 900)) // Foo(Max,900)
    println(foo.copy(name = "Phil", score = 1)) // Foo(Phil,1)

Ajoute une méthode copy

---

### CARACTERISTIQUES

Implémente une méthode unapply sur le companion object : permet de faire du pattern matching dessus et de les déstructurer facilement

---

### case object

    case object Something

Principaux avantages : toString et pattern matching facilité

===

# SELF TYPES

---

### DEFINITION

    trait MyTrait {
        val name: String
    }


    class MyClass { self: MyTrait =>
        // ici on sait que les instances implémenteront
        // forcément aussi MyTrait

        println(name)

    }


    // ne compile pas
    // class MyClass cannot be instantiated because it does
    // not conform to its self-type MyClass with MyTrait
    new MyClass
    // OK
    new MyClass with MyTrait {
        val name = ...
    }

===

# "ENUMS"

---

### ENUMERATION

    object Direction extends Enumeration {
      val North, West, East, South = Value
    }


    val someDirection = Direction.South

    val allDirections = Direction.values

    val someDirection = Direction.withName("East")

Première approche : Enumeration

---

### SEALED TRAIT

    // sealed = ne peux pas être étendu ailleurs que dans ce fichier
    sealed trait Direction
    case object North extends Direction
    case object West extends Direction
    case object East extends Direction
    case object South extends Direction

- Pas de conversion à partir de String automatique
- Pas de liste ordonnée des valeurs automatique
- Mais beaucoup, beaucoup plus souple...

Seconde approche : Sealed trait et case object

---

### SEALED TRAIT

    // réimplémentons les mêmes features
    sealed trait Direction { val name: String }
    case object North extends Direction { val name = "North" }
    case object West extends Direction { val name = "West" }
    case object East extends Direction { val name = "East" }
    case object South extends Direction { val name = "South" }

    val allDirections = Seq(North, West, East, South)

    def directionFromName(n: String) =
        allDirections.find(_.name == n)

---

### SEALED TRAIT

    // Mixons les objects et case classes

    sealed trait Equipe
    case object PSG extends Equipe
    case object OM extends Equipe

    sealed trait SurLeTerrain
    case object Arbitre extends SurLeTerrain
    case class Joueur(nom: String, equipe: Equipe) extends SurLeTerrain

===

# ENCORE QUELQUES FEATURES SYMPA

---

### XML Literal

    // dans build.sbt

    libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "1.0.2"


    val myXml = <foo>
        <bar attribut="value">Content</bar>
        <taz/>
    </foo>

---

### String INTERPOLATION

    // s interpolator

    val name = "James"
    println(s"Hello, $name")  // Hello, James
    println(s"1 + 1 = ${1 + 1}") // 1 + 1 = 2


    // f interpolator

    val height = 1.9d
    val name = "James"
    println(f"$name%s is $height%2.2f meters tall")  // James is 1.90 meters tall

    // on peut implémenter son propre interpolator !

---

### MULTILINE STRINGS

    val str = """Ceci
    est sur
    plusieurs lignes"""

    val str =
        """Ceci
          |est sur plusieurs lignes
          |et indenté proprement
        """.stripMargin

    val str = """Je peux aussi utiliser des "doubles quotes" dedans"""

    // double escape for regexp....
    val endsWithDotCom = "\\.com$".r
    // not anymore !
    val endsWithDotCom = """\.com$""".r

---

### RECURSION ET TAIL-RECURSION

    def lengthOfSeq(seq: Seq[String]): Int = {
      if (seq == Nil) 0
      else {
        val tail = seq.tail
        1 + lengthOfSeq(tail)
      }
    }

    def lengthOfSeq2(seq: Seq[String]): Int = {
      @tailrec
      def inner(seq: Seq[String], len: Int): Int = {
        if (seq == Nil) len
        else inner(seq.tail, len + 1)
      }
      inner(seq, 0)
    }

===

# Apply()

---

### APPLY()

    class Greeter {

        def apply(name: String) =
            println(s"Hello $name")

    }

    val greeter = new Greeter
    greeter.apply("Max") // Hello Max
    greeter("Fred") // Hello Fred

Utilisé très souvent dans companion objects pour définir des factories functions

---

### Les fonctions sont des classes comme les autres

    val makeUpperCase: String => String = s => s.toUpperCase
    // peut aussi être noté
    val makeUpperCase: Function1[String, String] = s => s.toUpperCase

    // ce qui veut dire en fait
    val makeUpperCase: Function1[String, String] = new Function[String, String] {
      override def apply(s: String): String =
        s.toUpperCase
    }


    // une fonction appelée ainsi
    println(makeUppercase("Hello")) // HELLO
    // peut toujours être appelée ainsi
    println(makeUppercase.apply("Hola")) // HOLA

---

### UPDATE()

    class Foo {
      def update(key: String, value: Int) =
        println(s"Calling method name with key $key and value $value")
    }

    val foo = new Foo

    foo("Joe") = 333 // Calling method name with key Joe and value 333
    // identique à
    foo.update("Joe", 333) // Calling method name with key Joe and value 333

Utilisé dans la librairie standard pour des collections mutables

(Map, etc.)

===

# TUPLES

---

### KEZAKO ?

    val myTuple: (String, Int, Boolean) = ("Hello", 500, false)

    // équivalent
    val myTuple: Tuple3[String, Int, Boolean] = ("Hello", 500, false)

    // équivalent
    val myTuple: Tuple3[String, Int, Boolean] = new Tuple3[String, Int, Boolean]("Hello", 500, false)



    // le type est enforcé
    val myTuple: (String, Int) = ("Hello", 500, false) // NE COMPILE PAS
    val myTuple: (String, Int, Int) = ("Hello", 500, false) // NE COMPILE PAS

Type contenant quelques valeurs de types hétérogènes

Pas une case classe : les valeurs ne sont pas nommées

Pas une collection : le nombre de valeurs et le type de chacune est enforcé

---

### Accès aux valeurs

    val myTuple = (3500, "Foo")

    println(myTuple._1) // 3500
    println(myTuple._2) // Foo



    // Destructuring
    val (myNumber, myString) = myTuple

    println(myString) = // Foo

---

### Arrow Syntax

    // un raccourci uniquement pour les tuples à 2 valeurs

    val foo = ("Max", 33)

    // équivalent à
    val foo = "Max" -> 33

---

### USAGE

- Retourner plusieurs valeurs d'une fonction
- Partout où on pourrait utiliser une case classe mais ça n'en valait pas la peine et on ne va pas la réutiliser

===

# PATTERN MATCHING

---

### KEZAKO ?

Un switch boosté aux hormones

D'une pierre deux coups :

- tester des conditions
- déstructurer les valeurs

---

### EXEMPLES

    val name = "Max"

    name match {
        // test on exact value
        case "Phil" =>
            println("It's Phil")
        case "Max" =>
            println("Oh it's Max")
        // default case
        case _ =>
            println("Not recognized")
    }

---

### EXEMPLES

    val name = "Max"

    val FavoriteName = "Bob"

    name match {
        // test on exact value
        case "Phil" =>
            println("It's Phil")

        // test on exact value coming from a val
        case FavoriteName =>
            println("Oh it's my favorite name")

        // any value, and make it accessible under a new val
        case otherName =>
            println(s"I don't know this name : $otherName")

    }

Attention à la majuscule !

---

### EXEMPLES

    val something: Any = ....

    something match {
        // if it's any value of type String
        case _: String =>
            println("It's a String")

        // if it's any value of type Int, and make it accessible under a new val
        case someInt: Int =>
            println(s"It's a Int : $someInt")

        case _ =>
            println("Some other type")

    }

---

### EXEMPLES

    sealed trait SurLeTerrain
    case object Arbitre extends SurLeTerrain
    case class Joueur(nom: String) extends SurLeTerrain


    val somebody: SurLeTerrain = ....


    somebody match {
        // teste si c'est un case object précis
        case Arbitre =>
            println("C'est l'arbitre")

        // destructure + teste sur une valeur
        case Joueur("Drogba") =>
            println("Vas-y Drogba !")

        // destructure + récupère la valeur
        case Joueur(name) =>
            println(s"Ah c'est un autre joueur : $name")

    }

---

### EXEMPLES

    val someTuple: (String, Int) = ("Max", 500)


    someTuple match {

        // idem avec les tuples

        case ("Fred", score) =>
            ...

        case ("Max", 1000) =>
            ...

        case (_, score) =>
            ...

    }

---

### EXEMPLES

    val someTuple: (String, Int) = ("Max", 500)


    someTuple match {

        // if guard
        case (name, score) if score > 200 =>
            ...

        case (name, score) =>
            ...


    }

---

### Nestable à l'INFINI

    val something = ...

    something match {

        case SomeCaseClass(((_: String), SomeName), true, foo) if foo.isEnabled =>
            ...

    }

---

### Pourquoi certains types peuvent être Déstructurés ?

Ils implémentent tous un extractor : la méthode unapply() dans leur companion object

    case class Foo(name: String, score: Int)


    // IMPLEMENTE AUTOMATIQUEMENT PAR LE COMPILEUR
    object Foo {

        def unapply(foo: Foo): Option[(String, Int)] =
            ...
    }

On peut donc définir des extractors customs sur nos types !

---

### Regexp

Les Regex ont un extractor très pratique pour tester et récupérer les groupes

    val BadEmailRegexp: Regex = """^(.+)@(.+)\.(.+)$""".r
    val email = ....

    email match {

      case BadEmailRegexp(userName, domain, extension) =>
          ...
    }

===

# Partial functions

---

### KEZAKO ?

Une Function qui en plus définit un périmètre d'application valide pour ses paramètres

    val divide42 = new PartialFunction[Int, Int] {

      def apply(d: Int) = 42 / d

      def isDefinedAt(d: Int) = d != 0

    }


    divide42.isDefinedAt(2) // true
    divide42(2) // 21
    divide42.isDefinedAt(0) // false
    divide42(0) // KO java.lang.ArithmeticException: / by zero

A un literal dédié

    val divide42: PartialFunction[Int, Int] = { case d if d != 0 =>
      42 / d
    }


    divide42.isDefinedAt(2) // true
    divide42(2) // 21
    divide42.isDefinedAt(0) // false
    // Différence : avec cette syntaxe Scala fait d'abord l'appel à isDefinedAt
    // et jette une exception si ça ne passe pas
    divide42(0) // KO scala.MatchError: 0 (of class java.lang.Integer)

---

### Pourquoi Faire ?

- match keyword
- catch keyword
- n'importe quelle autre fonction qui demande une PartialFunction en paramètre

  val result = Seq("Jean-Philippe", "Marie", "Yann").collect { case name if name.length < 6 =>
  name.head
  }
  println(result) // Seq(M, Y)

===

# EXceptions

---

### Exceptions

    def divide(num: Int, denum: Int): Int = {
        if (denum == 0)
            throw new RuntimeException("Can't divide by 0")
        num / denum
    }

    try {
      divide(35, 0)
    } catch {
      case e: SomeExceptionClass =>
        // ...
      case SomeCaseClassException(message) =>
        // ...
      case NonFatal(e) =>
        // tout exception sauf failures de la JVM (out of memory error, ...)
      case e =>
        // catch-all
        // ne JAMAIS utiliser
    }

---

### Exceptions

- Se base sur le fonctionnement des exceptions Java
- Pas de checked exceptions
- On peut jeter n'importe quelles sous-classes de Exception : celles existantes dans le JDK ou les notres
- Toujours utiliser l'extracteur NonFatal() si on veut traiter toutes les exceptions

===

# Listes de paramètres multiples

---

### KEZAKO

    def sayMessage1(name: String, uppercase: Boolean, word: String) = {
        val m = word + " " + name
        val m2 = if (uppercase) m.toUppercase else m
        println(m2)
    }


    def sayMessage2(name: String, uppercase: Boolean)(word: String) = {
        val m = word + " " + name
        val m2 = if (uppercase) m.toUppercase else m
        println(m2)
    }

    // usage
    sayMessage2("Max", true)("Hello") // HELLO MAX

---

### CURRYING

    def sayMessage2(name: String, uppercase: Boolean)(word: String) = {
        val m = word + " " + name
        val m2 = if (uppercase) m.toUppercase else m
        println(m2)
    }

    val saySomethingToMaxInUppercase = sayMessage2("Max", true)

    saySomethingToMaxInUppercase("Hello") // HELLO MAX

---

### PARTIALLY APPLIED FUNCTIONS

    def sayMessage(name: String, uppercase: Boolean, word: String) = {
        val m = word + " " + name
        val m2 = if (uppercase) m.toUppercase else m
        println(m2)
    }

    val sayHelloInUppercase = sayMessage(_, true, "Hello")

    sayHelloInUppercase("Max") // HELLO MAX

===

# TYPES GENERIQUES

---

### CLASSES GENERIQUES

    class Stack[A] {

      private var elems: Seq[A] = Seq()

      def push(a: A) =
        elems = a +: elems

      def pop(): A = {
        val a = elems.head
        elems = elems.tail
        a
      }

    }

    // le type peut être défini à l'instantiation
    val namesStack = new Stack[String]

    // ou au subclassage
    class IntStack extends Stack[Int]

---

### Methodes GENERIQUES

    def firstElementOfSeq[A](seq: Seq[A]): A =
        seq.head

---

### CONTRAINTES DE TYPES

    // un paramètre de type A
    class Stack[A] { ... }

    // deux paramètres de types, A et B
    class Stack[A, B] { ... }

    // A doit être un sous-type de User
    class Stack[A <: User] { ... }

    // deux paramètres de types, A et B
    // A doit être un sous-type B
    class Stack[A <: B, B] { ... }

---

### Encore plus de CONTRAINTES...

    [A <: B]

    [A >: B]

    [A <% B]

    [+A]

    [-A]

===

# IMPLICITS

---

### PARAMètres implicites

    def myFunction(foo: Foo)(implicit bar: Bar) = {
        ...
    }

    // -------
    // usage
    // -------

    val foo: Foo = ...
    implicit val bar: Bar = ...

    myFunction(foo) // OK, ça compile

    // exactement identique à
    myFunction(foo)(bar)

Conditions :

- doit être dans le scope (déclaré, passé en paramètre, ou importé)
- doit être marquée implicit
- doit avoir le bon type
- ne doit pas avoir d'ambiguité

---

### Conversions IMPLICITES

    case class Payment(amount: Int, currency: Currency)


    implicit def payment2Int(p: Payment): Int =
        p.amount



    // si on appelle n'importe quelle méthode de Int
    // directement sur un Payment

    val payment: Payment = ...
    val payment2: Payment = ...

    val newAmount = payment + 100 // ça compile

    // équivalent à
    val newAmount = payment2Int(payment) + 100

---

### Classes IMPLICITES

    implicit class RichInt(i: Int) {
        def times10 =
            i * 10
    }


    // on peut appeler la nouvelle méthode directement sur un Int
    println(24.times10) // 240

    // -----------------------
    // strictement équivalent à :

    class RichInt(i: Int) {
        def times10 =
            i * 10
    }

    implicit def int2RichInt(i: Int): RichInt =
        new RichInt(i)

===

# COLLECTIONS

---

### MUTABLES vs IMMUTABLES

    val myMap = Map(
      "Foo" -> 33,
      "Bar" -> 50
    )
    val myMap2 = myMap + ("Zoo" -> 33)

    println(myMap)  // Map(Foo -> 33, Bar -> 50)
    println(myMap2) // Map(Foo -> 33, Bar -> 50, Zoo -> 33)


    import scala.collection.mutable.Map

    val myMap = Map(
      "Foo" -> 33,
      "Bar" -> 50
    )
    myMap += "Zoo" -> 33

    println(myMap) // Map(Foo -> 33, Zoo -> 33, Bar -> 50)

---

<img src="scala/3374445c0d7605ebba5d1df9f73ed6f8.png"/>

---

### A RETENIR

- Traversable
- Iterable
- Seq
- Vector
- List
- Map
- Set
- Array
- Range

---

### Usage

    val names: Seq[String] = Seq("Max", "George", "Fred")

    // head / tail
    val firstName: String = names.head   // risque d'exception
    val firstNameMaybe: Option[String] = names.headOption
    val otherNames: Seq[String] = names.tail

    // direct access
    val secondName: String = names(1)  // risque d'exception
    val secondNameMaybe: Option[String] = names.lift(1)

    // size
    val size = names.length
    val size2 = names.size
    val isEmpty = names.isEmpty
    val notEmpty = names.nonEmpty

    // ajout
    val newNames = names :+ "Philippe"
    val newNames2 = "Alfred" +: names
    val newNames3 = names ++ Seq("Bob", "Brian")

    // conversion
    val namesList = names.toList
    val namesSet = names.toSet

---

### PLUS de Méthodes

    val names: Seq[String] = Seq("Max", "George", "Fred")

    names.foreach(println) // prints Max, then George, then Fred
    names.map(_.size) // Seq(3,6,4)
    names.filter(_.contains("e")) // Seq(George,Fred)
    names.find(_.contains("e")) // Some(George)
    names.exists(_.contains("e")) // true
    names.forall(_.contains("e")) // false
    names.count(_.contains("e")) // 2
    names.groupBy(_.length) // Map(4 -> List(Fred), 3 -> List(Max), 6 -> List(George))

    Seq(Seq("Max", "George"), Seq("Fred")).flatten // Seq(Max,George,Fred)
    names.map(_.toList).flatten // Seq(M, a, x, G, e, o, r, g, e, F, r, e, d)
    names.flatMap(_.toSeq) // Seq(M, a, x, G, e, o, r, g, e, F, r, e, d)

    names.collect { case n if n.size > 3 =>
        n.head
    } // Seq(G,F)


    names.take(2) // Seq(Max,George)
    names.takeWhile(_.size < 4) // Seq(Max)
    names.drop(1) // Seq(George,Fred)
    names.dropWhile(_.size < 4) // Seq(George,Fred)

    names.zip(Seq("A", "B")) // Seq((Max,A), (George,B))
    names.zipWithIndex // Seq((Max,0), (George,2), (Fred,3))

---

### EnCORE UN PEU PLUS

    val numbers = Seq(10, 2, 4)

    numbers.sum // 16
    numbers.reduce(_ + _) // 16  -- exception si empty
    numbers.reduceOption(_ + _) // Some(16)

    numbers.foldLeft(""){ case (previous, current) =>
        previous + current.toString
    } // 1024

- .reduce() pour cumuler un résultat
- .fold() pour cumuler un résultat avec une valeur initiale
- .scan() pour cumuler tous les résultats intermédiaires avec une valeur initiale
- Ces trois méthodes ne garantissent pas l'ordre
- Utiliser leurs variantes .xxxLeft() ou .xxxRight() pour être sûr de l'ordre

---

### MAP

    val myMap = Map(
        "Foo" -> 33,
        "Bar" -> 45
    )

    myMap("Foo") // 33   -- peut jeter une exception
    myMap.get("Foo") // Some(33)
    myMap.keys // Set(Foo,Bar)
    myMap.values // Seq(33,45)

    // une map peut toujours être vue comme une collection de tuples
    myMap.foreach { case (key, value) =>
        println(s"At key $key, we got $value")
    }

---

### For, MAP et FLATMAP

    val allOrderedProductsPrices = for {
      user <- getAllUsers
      order <- getOrdersOfUser(user)
      product <- getProductsOfOrder(order)
    } yield product.price


    val amountOfAllOrders = allOrderedProductsPrices.sum

    val amountOfAllOrders =
      getAllUsers.flatMap { user =>
        getOrdersOfUser(user).flatMap { order =>
          getProductsOfOrder(order).map(_.price)
        }
      }.size

===

# "COLLECTIONS-Like"

---

### Option

    val myMap: Map[String, Int] = ...

    val maybeValue: Option[Int] = myMap.get("key")

    maybeValue match {
        case Some(value) =>
            ...
        case None =>
            ...
    }

    maybeValue.getOrElse(0)

    // Utilisons les méthodes des collections

    maybeValue.isEmpty
    maybeValue.map(_ * 10)
    maybeValue.filter( _ < 5)

    // Mixons avec d'autres collections

    Seq("Phil", "Max", "", "Fred", "").flatMap(_.headOption) // Seq(P,M,F)

---

### TRY

    val usersTry = Try {
        getUsers
    }

    usersTry match {
        case Success(users) =>
            ...
        case Failure(throwable) =>
            ...
    }

    usersTry.getOrElse(Seq.empty)
    usersTry.isFailure
    usersTry.toOption

    // Comme une collection
    usersTry.map(_.size)
    usersTry.flatMap { users =>
        Try {
            ...
        }
    }

---

### FUTURE

    import scala.concurrent.ExecutionContext.Implicits.global

    val usersFuture: Future[Seq[User]] = Future {
      ...une operation qui prend du temps...
    }


    val users = Await.result(usersFuture, 10.seconds)


    usersFuture.foreach { users =>
        ...
    }

    usersFuture.map(_.size)

    usersFuture.flatMap { users =>
        fetchOrdersOfUsers(users)
    }

    usersFuture.recover { case NonFatal(t) =>
        ...
    }

===

# L'ECOSYSTèME

---

### Principales Librairies/FRamework/OUtils

- Play
- Spark
- Akka
- specs2
- ScalaTest
- Scala.js
- scalaz
- jodatime
- toutes les librairies Java
