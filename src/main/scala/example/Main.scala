package example
import org.apache.spark.SparkContext

import scala.collection.Map
import scala.collection.mutable.ArrayBuffer
import scala.util.Random
import org.apache.spark.broadcast.Broadcast
import org.apache.spark.SparkConf
import org.apache.spark.sql.{DataFrame, Dataset, SQLContext, SparkSession}

object Main extends App{
  val conf = new SparkConf().setMaster("local") //missing
  val spark = SparkSession
    .builder()
    .appName("Spark SQL basic example")
    .config(conf)
    .getOrCreate()
  val peptides = spark.read.format("csv").option("header", "true").option("inferSchema", "true").
    load("/home/rui/work/DeepNovo-pytorch/fasta_files/peaks_small_db_with_decoy.peptide.txt")
  peptides.printSchema()
  var numRows = peptides.count()
  println(s"$numRows raw peptides")
  peptides.show()
}

class Main {

}