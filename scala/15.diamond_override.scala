/*
diamond problem
*/
object Diamond_problem {
    trait Animal {
        def talk: String
    }
    trait Cat extends Animal {
        def talk: String = "I am Cat"
    }
    trait Monkey extends Animal {
        def talk: String = "I am monkey"
    }
    trait Dog extends Animal {
        override def talk: String = "I am Dog"
    }

    class MonkeyCat extends Monkey with Cat {
        override def talk: String = "I am monkeyCat"
    }

    def main(args: Array[String]): Unit = {
        val kittyDog = new Cat with Dog
        println(kittyDog.talk)
        val monkeyCat = new MonkeyCat
        println(monkeyCat.talk)
    }
}




