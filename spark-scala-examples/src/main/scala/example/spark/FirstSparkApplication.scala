package example.spark

import org.apache.spark.sql.SparkSession

object FirstSparkApplication {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder
      .master("local[*]")
      .appName("Sample App")
      .getOrCreate()

    val sc = spark.sparkContext

    val data = sc.parallelize(
      Seq("I like Spark",
        "Spark is awesome",
        "My first Spark job is working now and is counting down these words")
    )
    val filtered = data.filter(line => line.contains("awesome"))
    filtered.collect().foreach(print)

    sc.stop()
  }
}
