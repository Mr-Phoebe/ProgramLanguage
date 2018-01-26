object Test {
    def main(args: Array[String]) {
        // 字符串列表
        val site: List[String] = List("Runoob", "Google", "Baidu")

        // 整型列表
        val nums: List[Int] = List(1, 2, 3, 4)

        // 空列表
        val empty: List[Nothing] = List()

        // 二维列表
        val dim: List[List[Int]] =
           List(
              List(1, 0, 0),
              List(0, 1, 0),
              List(0, 0, 1)
           )
        // 字符串列表
        val site = "Runoob" :: ("Google" :: ("Baidu" :: Nil))

        // 整型列表
        val nums = 1 :: (2 :: (3 :: (4 :: Nil)))

        // 空列表
        val empty = Nil

        // 二维列表
        val dim = (1 :: (0 :: (0 :: Nil))) ::
                  (0 :: (1 :: (0 :: Nil))) ::
                  (0 :: (0 :: (1 :: Nil))) :: Nil
                  
        val site = "Runoob" :: ("Google" :: ("Baidu" :: Nil))
        val nums = Nil

        println( "第一网站是 : " + site.head )
        println( "最后一个网站是 : " + site.tail )
        println( "查看列表 site 是否为空 : " + site.isEmpty )
        println( "查看 nums 是否为空 : " + nums.isEmpty )
   }
}
