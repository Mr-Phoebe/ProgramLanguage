<HTML>
<HEAD>
<TITLE>图片</TITLE>
</HEAD>
<BODY>
<FONT SIZE=5>
<?php

        /*gd_info — 取得当前安装的 GD 库的信息
    getimagesize — 取得图像大小
    getimagesizefromstring — 从字符串中获取图像尺寸信息
    image_type_to_extension — 取得图像类型的文件后缀
    image_type_to_mime_type — 取得 getimagesize，exif_read_data，exif_thumbnail，exif_imagetype 所返回的图像类型的 MIME 类型
    image2wbmp — 以 WBMP 格式将图像输出到浏览器或文件
    imageaffine — 返回经过仿射变换后的图像，剪切区域可选
    imageaffinematrixconcat — Concatenate two affine transformation matrices
    imageaffinematrixget — Get an affine transformation matrix
    imagealphablending — 设定图像的混色模式
    imageantialias — 是否使用抗锯齿（antialias）功能
    imagearc — 画椭圆弧
    imagebmp — Output a BMP image to browser or file
    imagechar — 水平地画一个字符
    imagecharup — 垂直地画一个字符
    imagecolorallocate — 为一幅图像分配颜色
    imagecolorallocatealpha — 为一幅图像分配颜色 + alpha
    imagecolorat — 取得某像素的颜色索引值
    imagecolorclosest — 取得与指定的颜色最接近的颜色的索引值
    imagecolorclosestalpha — 取得与指定的颜色加透明度最接近的颜色
    imagecolorclosesthwb — 取得与给定颜色最接近的色度的黑白色的索引
    imagecolordeallocate — 取消图像颜色的分配
    imagecolorexact — 取得指定颜色的索引值
    imagecolorexactalpha — 取得指定的颜色加透明度的索引值
    imagecolormatch — 使一个图像中调色板版本的颜色与真彩色版本更能匹配
    imagecolorresolve — 取得指定颜色的索引值或有可能得到的最接近的替代值
    imagecolorresolvealpha — 取得指定颜色 + alpha 的索引值或有可能得到的最接近的替代值
    imagecolorset — 给指定调色板索引设定颜色
    imagecolorsforindex — 取得某索引的颜色
    imagecolorstotal — 取得一幅图像的调色板中颜色的数目
    imagecolortransparent — 将某个颜色定义为透明色
    imageconvolution — 用系数 div 和 offset 申请一个 3x3 的卷积矩阵
    imagecopy — 拷贝图像的一部分
    imagecopymerge — 拷贝并合并图像的一部分
    imagecopymergegray — 用灰度拷贝并合并图像的一部分
    imagecopyresampled — 重采样拷贝部分图像并调整大小
    imagecopyresized — 拷贝部分图像并调整大小
    imagecreate — 新建一个基于调色板的图像
    imagecreatefrombmp — 由文件或 URL 创建一个新图象。
    imagecreatefromgd2 — 从 GD2 文件或 URL 新建一图像
    imagecreatefromgd2part — 从给定的 GD2 文件或 URL 中的部分新建一图像
    imagecreatefromgd — 从 GD 文件或 URL 新建一图像
    imagecreatefromgif — 由文件或 URL 创建一个新图象。
    imagecreatefromjpeg — 由文件或 URL 创建一个新图象。
    imagecreatefrompng — 由文件或 URL 创建一个新图象。
    imagecreatefromstring — 从字符串中的图像流新建一图像
    imagecreatefromwbmp — 由文件或 URL 创建一个新图象。
    imagecreatefromwebp — 由文件或 URL 创建一个新图象。
    imagecreatefromxbm — 由文件或 URL 创建一个新图象。
    imagecreatefromxpm — 由文件或 URL 创建一个新图象。
    imagecreatetruecolor — 新建一个真彩色图像
    imagecrop — Crop an image to the given rectangle
    imagecropauto — Crop an image automatically using one of the available modes
    imagedashedline — 画一虚线
    imagedestroy — 销毁一图像
    imageellipse — 画一个椭圆
    imagefill — 区域填充
    imagefilledarc — 画一椭圆弧且填充
    imagefilledellipse — 画一椭圆并填充
    imagefilledpolygon — 画一多边形并填充
    imagefilledrectangle — 画一矩形并填充
    imagefilltoborder — 区域填充到指定颜色的边界为止
    imagefilter — 对图像使用过滤器
    imageflip — Flips an image using a given mode
    imagefontheight — 取得字体高度
    imagefontwidth — 取得字体宽度
    imageftbbox — 给出一个使用 FreeType 2 字体的文本框
    imagefttext — 使用 FreeType 2 字体将文本写入图像
    imagegammacorrect — 对 GD 图像应用 gamma 修正
    imagegd2 — 将 GD2 图像输出到浏览器或文件
    imagegd — 将 GD 图像输出到浏览器或文件
    imagegetclip — Get the clipping rectangle
    imagegif — 输出图象到浏览器或文件。
    imagegrabscreen — Captures the whole screen
    imagegrabwindow — Captures a window
    imageinterlace — 激活或禁止隔行扫描
    imageistruecolor — 检查图像是否为真彩色图像
    imagejpeg — 输出图象到浏览器或文件。
    imagelayereffect — 设定 alpha 混色标志以使用绑定的 libgd 分层效果
    imageline — 画一条线段
    imageloadfont — 载入一新字体
    imageopenpolygon — Draws an open polygon
    imagepalettecopy — 将调色板从一幅图像拷贝到另一幅
    imagepalettetotruecolor — Converts a palette based image to true color
    imagepng — 以 PNG 格式将图像输出到浏览器或文件
    imagepolygon — 画一个多边形
    imagepsbbox — 给出一个使用 PostScript Type1 字体的文本方框
    imagepsencodefont — 改变字体中的字符编码矢量
    imagepsextendfont — 扩充或精简字体
    imagepsfreefont — 释放一个 PostScript Type 1 字体所占用的内存
    imagepsloadfont — 从文件中加载一个 PostScript Type 1 字体
    imagepsslantfont — 倾斜某字体
    imagepstext — 用 PostScript Type1 字体把文本字符串画在图像上
    imagerectangle — 画一个矩形
    imageresolution — Get or set the resolution of the image
    imagerotate — 用给定角度旋转图像
    imagesavealpha — 设置标记以在保存 PNG 图像时保存完整的 alpha 通道信息（与单一透明色相反）
    imagescale — Scale an image using the given new width and height
    imagesetbrush — 设定画线用的画笔图像
    imagesetclip — Set the clipping rectangle
    imagesetinterpolation — Set the interpolation method
    imagesetpixel — 画一个单一像素
    imagesetstyle — 设定画线的风格
    imagesetthickness — 设定画线的宽度
    imagesettile — 设定用于填充的贴图
    imagestring — 水平地画一行字符串
    imagestringup — 垂直地画一行字符串
    imagesx — 取得图像宽度
    imagesy — 取得图像高度
    imagetruecolortopalette — 将真彩色图像转换为调色板图像
    imagettfbbox — 取得使用 TrueType 字体的文本的范围
    imagettftext — 用 TrueType 字体向图像写入文本
    imagetypes — 返回当前 PHP 版本所支持的图像类型
    imagewbmp — 以 WBMP 格式将图像输出到浏览器或文件
    imagewebp — 将 WebP 格式的图像输出到浏览器或文件
    imagexbm — 将 XBM 图像输出到浏览器或文件
    iptcembed — 将二进制 IPTC 数据嵌入到一幅 JPEG 图像中
    iptcparse — 将二进制 IPTC 块解析为单个标记
    jpeg2wbmp — 将 JPEG 图像文件转换为 WBMP 图像文件
    png2wbmp — 将 PNG 图像文件转换为 WBMP 图像文件*/
?>
</FONT>
</BODY>
</HTML> 