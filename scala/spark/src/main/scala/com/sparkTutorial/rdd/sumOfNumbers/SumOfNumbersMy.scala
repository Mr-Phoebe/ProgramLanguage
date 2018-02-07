package com.sparkTutorial.rdd.sumOfNumbers

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}

object SumOfNumbersMy {

    def main(args: Array[String]) {

        /* Create a Spark program to read the first 100 prime numbers from in/prime_nums.text,
           print the sum of those numbers to console.

           Each row of the input file contains 10 prime numbers separated by spaces.
         */
        Logger.getLogger("org").setLevel(Level.OFF)

        val conf = new SparkConf().setAppName("primeNumbers").setMaster("local[*]")
        val sc = new SparkContext(conf)

        val lines = sc.textFile("in/prime_nums.text")

        val numbers = lines.flatMap(line => line.split("\\s+"))
                            .filter(dig => !dig.isEmpty)
                            .map(dig => dig.toInt)

        println(numbers.sum)
        println(numbers.reduce((x, y) => x + y))
    }
}

