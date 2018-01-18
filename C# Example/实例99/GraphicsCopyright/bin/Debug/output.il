
//  Microsoft (R) .NET Framework IL Disassembler.  Version 1.0.2914.16
//  Copyright (C) Microsoft Corp. 1998-2001. All rights reserved.

// VTableFixup Directory:
// No data.
.assembly extern System.Windows.Forms
{
  .publickeytoken = (B7 7A 5C 56 19 34 E0 89 )                         // .z\V.4..
  .ver 1:0:2411:0
}
.assembly extern System.Drawing
{
  .publickeytoken = (B0 3F 5F 7F 11 D5 0A 3A )                         // .?_....:
  .ver 1:0:2411:0
}
.assembly extern System
{
  .publickeytoken = (B7 7A 5C 56 19 34 E0 89 )                         // .z\V.4..
  .ver 1:0:2411:0
}
.assembly extern mscorlib
{
  .publickeytoken = (B7 7A 5C 56 19 34 E0 89 )                         // .z\V.4..
  .ver 1:0:2411:0
}
.assembly GraphicsCopyright
{
  .custom instance void [mscorlib]System.Reflection.AssemblyCopyrightAttribute::.ctor(string) = ( 01 00 00 00 00 ) 
  .custom instance void [mscorlib]System.Reflection.AssemblyKeyNameAttribute::.ctor(string) = ( 01 00 00 00 00 ) 
  .custom instance void [mscorlib]System.Reflection.AssemblyKeyFileAttribute::.ctor(string) = ( 01 00 00 00 00 ) 
  .custom instance void [mscorlib]System.Reflection.AssemblyDelaySignAttribute::.ctor(bool) = ( 01 00 00 00 00 ) 
  .custom instance void [mscorlib]System.Reflection.AssemblyTrademarkAttribute::.ctor(string) = ( 01 00 00 00 00 ) 
  .custom instance void [mscorlib]System.Reflection.AssemblyConfigurationAttribute::.ctor(string) = ( 01 00 00 00 00 ) 
  // --- The following custom attribute is added automatically, do not uncomment -------
  //  .custom instance void [mscorlib]System.Diagnostics.DebuggableAttribute::.ctor(bool,
  //                                                                                bool) = ( 01 00 01 01 00 00 ) 
  .custom instance void [mscorlib]System.Reflection.AssemblyCompanyAttribute::.ctor(string) = ( 01 00 00 00 00 ) 
  .custom instance void [mscorlib]System.Reflection.AssemblyProductAttribute::.ctor(string) = ( 01 00 00 00 00 ) 
  .custom instance void [mscorlib]System.Reflection.AssemblyDescriptionAttribute::.ctor(string) = ( 01 00 00 00 00 ) 
  .custom instance void [mscorlib]System.Reflection.AssemblyTitleAttribute::.ctor(string) = ( 01 00 00 00 00 ) 
  .hash algorithm 0x00008004
  .ver 1:0:633:29881
}
.mresource public GraphicsCopyright.Form1.resources
{
  // WARNING: managed resource file GraphicsCopyright.Form1.resources created
}
.mresource public GraphicsCopyright.exe.licenses
{
  // WARNING: managed resource file GraphicsCopyright.exe.licenses created
}
.module GraphicsCopyright.exe
// MVID: {0F54C490-D937-46AC-94FA-A2F17E8E428C}
.imagebase 0x00400000
.subsystem 0x00000002
.file alignment 512
.corflags 0x00000001
// Image base: 0x02ff0000
.namespace GraphicsCopyright
{
  .class public auto ansi beforefieldinit Form1
         extends [System.Windows.Forms]System.Windows.Forms.Form
  {
    .field private class [System.Drawing]System.Drawing.Image originalimage
    .field private class [System.Windows.Forms]System.Windows.Forms.OpenFileDialog openFileDialog1
    .field private class [System.Windows.Forms]System.Windows.Forms.PictureBox pictureBox1
    .field private class [System.Windows.Forms]System.Windows.Forms.MainMenu mainMenu1
    .field private class [System.Windows.Forms]System.Windows.Forms.MenuItem menuItem1
    .field private class [System.Windows.Forms]System.Windows.Forms.MenuItem menuItem2
    .field private class [System.Windows.Forms]System.Windows.Forms.GroupBox groupBox1
    .field private class [System.Windows.Forms]System.Windows.Forms.MenuItem menuItem3
    .field private class [System.Windows.Forms]System.Windows.Forms.MenuItem menuItem4
    .field private class [System.Windows.Forms]System.Windows.Forms.Button button1
    .field private class [System.Windows.Forms]System.Windows.Forms.ProgressBar progressBar1
    .field private class [System]System.ComponentModel.Container components
    .method public hidebysig specialname rtspecialname 
            instance void  .ctor() cil managed
    {
      // Code size       20 (0x14)
      .maxstack  8
      IL_0000:  ldarg.0
      IL_0001:  ldnull
      IL_0002:  stfld      class [System]System.ComponentModel.Container GraphicsCopyright.Form1::components
      IL_0007:  ldarg.0
      IL_0008:  call       instance void [System.Windows.Forms]System.Windows.Forms.Form::.ctor()
      IL_000d:  ldarg.0
      IL_000e:  call       instance void GraphicsCopyright.Form1::InitializeComponent()
      IL_0013:  ret
    } // end of method Form1::.ctor

    .method family hidebysig virtual instance void 
            Dispose(bool disposing) cil managed
    {
      // Code size       30 (0x1e)
      .maxstack  8
      IL_0000:  ldarg.1
      IL_0001:  brfalse.s  IL_0016

      IL_0003:  ldarg.0
      IL_0004:  ldfld      class [System]System.ComponentModel.Container GraphicsCopyright.Form1::components
      IL_0009:  brfalse.s  IL_0016

      IL_000b:  ldarg.0
      IL_000c:  ldfld      class [System]System.ComponentModel.Container GraphicsCopyright.Form1::components
      IL_0011:  callvirt   instance void [System]System.ComponentModel.Container::Dispose()
      IL_0016:  ldarg.0
      IL_0017:  ldarg.1
      IL_0018:  call       instance void [System.Windows.Forms]System.Windows.Forms.Form::Dispose(bool)
      IL_001d:  ret
    } // end of method Form1::Dispose

    .method private hidebysig instance void 
            InitializeComponent() cil managed
    {
      // Code size       928 (0x3a0)
      .maxstack  4
      .locals ([0] class [System.Windows.Forms]System.Windows.Forms.MenuItem[] CS$00000002$00000000,
               [1] class [System.Windows.Forms]System.Windows.Forms.MenuItem[] CS$00000002$00000001,
               [2] class [System.Windows.Forms]System.Windows.Forms.MenuItem[] CS$00000002$00000002,
               [3] class [System.Windows.Forms]System.Windows.Forms.Control[] CS$00000002$00000003,
               [4] class [System.Windows.Forms]System.Windows.Forms.Control[] CS$00000002$00000004)
      IL_0000:  ldarg.0
      IL_0001:  newobj     instance void [System.Windows.Forms]System.Windows.Forms.MenuItem::.ctor()
      IL_0006:  stfld      class [System.Windows.Forms]System.Windows.Forms.MenuItem GraphicsCopyright.Form1::menuItem4
      IL_000b:  ldarg.0
      IL_000c:  newobj     instance void [System.Windows.Forms]System.Windows.Forms.Button::.ctor()
      IL_0011:  stfld      class [System.Windows.Forms]System.Windows.Forms.Button GraphicsCopyright.Form1::button1
      IL_0016:  ldarg.0
      IL_0017:  newobj     instance void [System.Windows.Forms]System.Windows.Forms.ProgressBar::.ctor()
      IL_001c:  stfld      class [System.Windows.Forms]System.Windows.Forms.ProgressBar GraphicsCopyright.Form1::progressBar1
      IL_0021:  ldarg.0
      IL_0022:  newobj     instance void [System.Windows.Forms]System.Windows.Forms.MenuItem::.ctor()
      IL_0027:  stfld      class [System.Windows.Forms]System.Windows.Forms.MenuItem GraphicsCopyright.Form1::menuItem1
      IL_002c:  ldarg.0
      IL_002d:  newobj     instance void [System.Windows.Forms]System.Windows.Forms.MenuItem::.ctor()
      IL_0032:  stfld      class [System.Windows.Forms]System.Windows.Forms.MenuItem GraphicsCopyright.Form1::menuItem2
      IL_0037:  ldarg.0
      IL_0038:  newobj     instance void [System.Windows.Forms]System.Windows.Forms.MenuItem::.ctor()
      IL_003d:  stfld      class [System.Windows.Forms]System.Windows.Forms.MenuItem GraphicsCopyright.Form1::menuItem3
      IL_0042:  ldarg.0
      IL_0043:  newobj     instance void [System.Windows.Forms]System.Windows.Forms.MainMenu::.ctor()
      IL_0048:  stfld      class [System.Windows.Forms]System.Windows.Forms.MainMenu GraphicsCopyright.Form1::mainMenu1
      IL_004d:  ldarg.0
      IL_004e:  newobj     instance void [System.Windows.Forms]System.Windows.Forms.PictureBox::.ctor()
      IL_0053:  stfld      class [System.Windows.Forms]System.Windows.Forms.PictureBox GraphicsCopyright.Form1::pictureBox1
      IL_0058:  ldarg.0
      IL_0059:  newobj     instance void [System.Windows.Forms]System.Windows.Forms.OpenFileDialog::.ctor()
      IL_005e:  stfld      class [System.Windows.Forms]System.Windows.Forms.OpenFileDialog GraphicsCopyright.Form1::openFileDialog1
      IL_0063:  ldarg.0
      IL_0064:  newobj     instance void [System.Windows.Forms]System.Windows.Forms.GroupBox::.ctor()
      IL_0069:  stfld      class [System.Windows.Forms]System.Windows.Forms.GroupBox GraphicsCopyright.Form1::groupBox1
      IL_006e:  ldarg.0
      IL_006f:  ldfld      class [System.Windows.Forms]System.Windows.Forms.GroupBox GraphicsCopyright.Form1::groupBox1
      IL_0074:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.Control::SuspendLayout()
      IL_0079:  ldarg.0
      IL_007a:  call       instance void [System.Windows.Forms]System.Windows.Forms.Control::SuspendLayout()
      IL_007f:  ldarg.0
      IL_0080:  ldfld      class [System.Windows.Forms]System.Windows.Forms.MenuItem GraphicsCopyright.Form1::menuItem4
      IL_0085:  ldc.i4.0
      IL_0086:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.MenuItem::set_Index(int32)
      IL_008b:  ldarg.0
      IL_008c:  ldfld      class [System.Windows.Forms]System.Windows.Forms.MenuItem GraphicsCopyright.Form1::menuItem4
      IL_0091:  ldstr      "About"
      IL_0096:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.MenuItem::set_Text(string)
      IL_009b:  ldarg.0
      IL_009c:  ldfld      class [System.Windows.Forms]System.Windows.Forms.Button GraphicsCopyright.Form1::button1
      IL_00a1:  ldc.i4.8
      IL_00a2:  ldc.i4.s   16
      IL_00a4:  newobj     instance void [System.Drawing]System.Drawing.Point::.ctor(int32,
                                                                                     int32)
      IL_00a9:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.Control::set_Location(valuetype [System.Drawing]System.Drawing.Point)
      IL_00ae:  ldarg.0
      IL_00af:  ldfld      class [System.Windows.Forms]System.Windows.Forms.Button GraphicsCopyright.Form1::button1
      IL_00b4:  ldstr      "button1"
      IL_00b9:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.Control::set_Name(string)
      IL_00be:  ldarg.0
      IL_00bf:  ldfld      class [System.Windows.Forms]System.Windows.Forms.Button GraphicsCopyright.Form1::button1
      IL_00c4:  ldc.i4     0x80
      IL_00c9:  ldc.i4.s   32
      IL_00cb:  newobj     instance void [System.Drawing]System.Drawing.Size::.ctor(int32,
                                                                                    int32)
      IL_00d0:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.Control::set_Size(valuetype [System.Drawing]System.Drawing.Size)
      IL_00d5:  ldarg.0
      IL_00d6:  ldfld      class [System.Windows.Forms]System.Windows.Forms.Button GraphicsCopyright.Form1::button1
      IL_00db:  ldc.i4.0
      IL_00dc:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.Control::set_TabIndex(int32)
      IL_00e1:  ldarg.0
      IL_00e2:  ldfld      class [System.Windows.Forms]System.Windows.Forms.Button GraphicsCopyright.Form1::button1
      IL_00e7:  ldstr      "Add Copyright"
      IL_00ec:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.Control::set_Text(string)
      IL_00f1:  ldarg.0
      IL_00f2:  ldfld      class [System.Windows.Forms]System.Windows.Forms.Button GraphicsCopyright.Form1::button1
      IL_00f7:  ldarg.0
      IL_00f8:  ldftn      instance void GraphicsCopyright.Form1::button1_Click(object,
                                                                                class [mscorlib]System.EventArgs)
      IL_00fe:  newobj     instance void [mscorlib]System.EventHandler::.ctor(object,
                                                                              native unsigned int)
      IL_0103:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.Control::add_Click(class [mscorlib]System.EventHandler)
      IL_0108:  ldarg.0
      IL_0109:  ldfld      class [System.Windows.Forms]System.Windows.Forms.ProgressBar GraphicsCopyright.Form1::progressBar1
      IL_010e:  ldc.i4.8
      IL_010f:  ldc.i4     0x88
      IL_0114:  newobj     instance void [System.Drawing]System.Drawing.Point::.ctor(int32,
                                                                                     int32)
      IL_0119:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.Control::set_Location(valuetype [System.Drawing]System.Drawing.Point)
      IL_011e:  ldarg.0
      IL_011f:  ldfld      class [System.Windows.Forms]System.Windows.Forms.ProgressBar GraphicsCopyright.Form1::progressBar1
      IL_0124:  ldstr      "progressBar1"
      IL_0129:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.Control::set_Name(string)
      IL_012e:  ldarg.0
      IL_012f:  ldfld      class [System.Windows.Forms]System.Windows.Forms.ProgressBar GraphicsCopyright.Form1::progressBar1
      IL_0134:  ldc.i4     0x108
      IL_0139:  ldc.i4.s   23
      IL_013b:  newobj     instance void [System.Drawing]System.Drawing.Size::.ctor(int32,
                                                                                    int32)
      IL_0140:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.Control::set_Size(valuetype [System.Drawing]System.Drawing.Size)
      IL_0145:  ldarg.0
      IL_0146:  ldfld      class [System.Windows.Forms]System.Windows.Forms.ProgressBar GraphicsCopyright.Form1::progressBar1
      IL_014b:  ldc.i4.s   100
      IL_014d:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.ProgressBar::set_Step(int32)
      IL_0152:  ldarg.0
      IL_0153:  ldfld      class [System.Windows.Forms]System.Windows.Forms.ProgressBar GraphicsCopyright.Form1::progressBar1
      IL_0158:  ldc.i4.2
      IL_0159:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.Control::set_TabIndex(int32)
      IL_015e:  ldarg.0
      IL_015f:  ldfld      class [System.Windows.Forms]System.Windows.Forms.MenuItem GraphicsCopyright.Form1::menuItem1
      IL_0164:  ldc.i4.0
      IL_0165:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.MenuItem::set_Index(int32)
      IL_016a:  ldarg.0
      IL_016b:  ldfld      class [System.Windows.Forms]System.Windows.Forms.MenuItem GraphicsCopyright.Form1::menuItem1
      IL_0170:  callvirt   instance class [System.Windows.Forms]System.Windows.Forms.Menu/MenuItemCollection [System.Windows.Forms]System.Windows.Forms.Menu::get_MenuItems()
      IL_0175:  ldc.i4.1
      IL_0176:  newarr     [System.Windows.Forms]System.Windows.Forms.MenuItem
      IL_017b:  stloc.0
      IL_017c:  ldloc.0
      IL_017d:  ldc.i4.0
      IL_017e:  ldarg.0
      IL_017f:  ldfld      class [System.Windows.Forms]System.Windows.Forms.MenuItem GraphicsCopyright.Form1::menuItem2
      IL_0184:  stelem.ref
      IL_0185:  ldloc.0
      IL_0186:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.Menu/MenuItemCollection::AddRange(class [System.Windows.Forms]System.Windows.Forms.MenuItem[])
      IL_018b:  ldarg.0
      IL_018c:  ldfld      class [System.Windows.Forms]System.Windows.Forms.MenuItem GraphicsCopyright.Form1::menuItem1
      IL_0191:  ldstr      "File"
      IL_0196:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.MenuItem::set_Text(string)
      IL_019b:  ldarg.0
      IL_019c:  ldfld      class [System.Windows.Forms]System.Windows.Forms.MenuItem GraphicsCopyright.Form1::menuItem2
      IL_01a1:  ldc.i4.0
      IL_01a2:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.MenuItem::set_Index(int32)
      IL_01a7:  ldarg.0
      IL_01a8:  ldfld      class [System.Windows.Forms]System.Windows.Forms.MenuItem GraphicsCopyright.Form1::menuItem2
      IL_01ad:  ldstr      "Open"
      IL_01b2:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.MenuItem::set_Text(string)
      IL_01b7:  ldarg.0
      IL_01b8:  ldfld      class [System.Windows.Forms]System.Windows.Forms.MenuItem GraphicsCopyright.Form1::menuItem2
      IL_01bd:  ldarg.0
      IL_01be:  ldftn      instance void GraphicsCopyright.Form1::menuItem2_Click(object,
                                                                                  class [mscorlib]System.EventArgs)
      IL_01c4:  newobj     instance void [mscorlib]System.EventHandler::.ctor(object,
                                                                              native unsigned int)
      IL_01c9:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.MenuItem::add_Click(class [mscorlib]System.EventHandler)
      IL_01ce:  ldarg.0
      IL_01cf:  ldfld      class [System.Windows.Forms]System.Windows.Forms.MenuItem GraphicsCopyright.Form1::menuItem3
      IL_01d4:  ldc.i4.1
      IL_01d5:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.MenuItem::set_Index(int32)
      IL_01da:  ldarg.0
      IL_01db:  ldfld      class [System.Windows.Forms]System.Windows.Forms.MenuItem GraphicsCopyright.Form1::menuItem3
      IL_01e0:  callvirt   instance class [System.Windows.Forms]System.Windows.Forms.Menu/MenuItemCollection [System.Windows.Forms]System.Windows.Forms.Menu::get_MenuItems()
      IL_01e5:  ldc.i4.1
      IL_01e6:  newarr     [System.Windows.Forms]System.Windows.Forms.MenuItem
      IL_01eb:  stloc.1
      IL_01ec:  ldloc.1
      IL_01ed:  ldc.i4.0
      IL_01ee:  ldarg.0
      IL_01ef:  ldfld      class [System.Windows.Forms]System.Windows.Forms.MenuItem GraphicsCopyright.Form1::menuItem4
      IL_01f4:  stelem.ref
      IL_01f5:  ldloc.1
      IL_01f6:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.Menu/MenuItemCollection::AddRange(class [System.Windows.Forms]System.Windows.Forms.MenuItem[])
      IL_01fb:  ldarg.0
      IL_01fc:  ldfld      class [System.Windows.Forms]System.Windows.Forms.MenuItem GraphicsCopyright.Form1::menuItem3
      IL_0201:  ldstr      "Help"
      IL_0206:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.MenuItem::set_Text(string)
      IL_020b:  ldarg.0
      IL_020c:  ldfld      class [System.Windows.Forms]System.Windows.Forms.MainMenu GraphicsCopyright.Form1::mainMenu1
      IL_0211:  callvirt   instance class [System.Windows.Forms]System.Windows.Forms.Menu/MenuItemCollection [System.Windows.Forms]System.Windows.Forms.Menu::get_MenuItems()
      IL_0216:  ldc.i4.2
      IL_0217:  newarr     [System.Windows.Forms]System.Windows.Forms.MenuItem
      IL_021c:  stloc.2
      IL_021d:  ldloc.2
      IL_021e:  ldc.i4.0
      IL_021f:  ldarg.0
      IL_0220:  ldfld      class [System.Windows.Forms]System.Windows.Forms.MenuItem GraphicsCopyright.Form1::menuItem1
      IL_0225:  stelem.ref
      IL_0226:  ldloc.2
      IL_0227:  ldc.i4.1
      IL_0228:  ldarg.0
      IL_0229:  ldfld      class [System.Windows.Forms]System.Windows.Forms.MenuItem GraphicsCopyright.Form1::menuItem3
      IL_022e:  stelem.ref
      IL_022f:  ldloc.2
      IL_0230:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.Menu/MenuItemCollection::AddRange(class [System.Windows.Forms]System.Windows.Forms.MenuItem[])
      IL_0235:  ldarg.0
      IL_0236:  ldfld      class [System.Windows.Forms]System.Windows.Forms.PictureBox GraphicsCopyright.Form1::pictureBox1
      IL_023b:  ldc.i4     0xa0
      IL_0240:  ldc.i4.s   16
      IL_0242:  newobj     instance void [System.Drawing]System.Drawing.Point::.ctor(int32,
                                                                                     int32)
      IL_0247:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.Control::set_Location(valuetype [System.Drawing]System.Drawing.Point)
      IL_024c:  ldarg.0
      IL_024d:  ldfld      class [System.Windows.Forms]System.Windows.Forms.PictureBox GraphicsCopyright.Form1::pictureBox1
      IL_0252:  ldstr      "pictureBox1"
      IL_0257:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.Control::set_Name(string)
      IL_025c:  ldarg.0
      IL_025d:  ldfld      class [System.Windows.Forms]System.Windows.Forms.PictureBox GraphicsCopyright.Form1::pictureBox1
      IL_0262:  ldc.i4.s   100
      IL_0264:  ldc.i4.s   100
      IL_0266:  newobj     instance void [System.Drawing]System.Drawing.Size::.ctor(int32,
                                                                                    int32)
      IL_026b:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.Control::set_Size(valuetype [System.Drawing]System.Drawing.Size)
      IL_0270:  ldarg.0
      IL_0271:  ldfld      class [System.Windows.Forms]System.Windows.Forms.PictureBox GraphicsCopyright.Form1::pictureBox1
      IL_0276:  ldc.i4.0
      IL_0277:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.PictureBox::set_TabIndex(int32)
      IL_027c:  ldarg.0
      IL_027d:  ldfld      class [System.Windows.Forms]System.Windows.Forms.PictureBox GraphicsCopyright.Form1::pictureBox1
      IL_0282:  ldc.i4.0
      IL_0283:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.PictureBox::set_TabStop(bool)
      IL_0288:  ldarg.0
      IL_0289:  ldfld      class [System.Windows.Forms]System.Windows.Forms.GroupBox GraphicsCopyright.Form1::groupBox1
      IL_028e:  callvirt   instance class [System.Windows.Forms]System.Windows.Forms.Control/ControlCollection [System.Windows.Forms]System.Windows.Forms.Control::get_Controls()
      IL_0293:  ldc.i4.1
      IL_0294:  newarr     [System.Windows.Forms]System.Windows.Forms.Control
      IL_0299:  stloc.3
      IL_029a:  ldloc.3
      IL_029b:  ldc.i4.0
      IL_029c:  ldarg.0
      IL_029d:  ldfld      class [System.Windows.Forms]System.Windows.Forms.Button GraphicsCopyright.Form1::button1
      IL_02a2:  stelem.ref
      IL_02a3:  ldloc.3
      IL_02a4:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.Control/ControlCollection::AddRange(class [System.Windows.Forms]System.Windows.Forms.Control[])
      IL_02a9:  ldarg.0
      IL_02aa:  ldfld      class [System.Windows.Forms]System.Windows.Forms.GroupBox GraphicsCopyright.Form1::groupBox1
      IL_02af:  ldc.i4.8
      IL_02b0:  ldc.i4.0
      IL_02b1:  newobj     instance void [System.Drawing]System.Drawing.Point::.ctor(int32,
                                                                                     int32)
      IL_02b6:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.Control::set_Location(valuetype [System.Drawing]System.Drawing.Point)
      IL_02bb:  ldarg.0
      IL_02bc:  ldfld      class [System.Windows.Forms]System.Windows.Forms.GroupBox GraphicsCopyright.Form1::groupBox1
      IL_02c1:  ldstr      "groupBox1"
      IL_02c6:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.Control::set_Name(string)
      IL_02cb:  ldarg.0
      IL_02cc:  ldfld      class [System.Windows.Forms]System.Windows.Forms.GroupBox GraphicsCopyright.Form1::groupBox1
      IL_02d1:  ldc.i4     0x108
      IL_02d6:  ldc.i4     0x80
      IL_02db:  newobj     instance void [System.Drawing]System.Drawing.Size::.ctor(int32,
                                                                                    int32)
      IL_02e0:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.Control::set_Size(valuetype [System.Drawing]System.Drawing.Size)
      IL_02e5:  ldarg.0
      IL_02e6:  ldfld      class [System.Windows.Forms]System.Windows.Forms.GroupBox GraphicsCopyright.Form1::groupBox1
      IL_02eb:  ldc.i4.1
      IL_02ec:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.Control::set_TabIndex(int32)
      IL_02f1:  ldarg.0
      IL_02f2:  ldfld      class [System.Windows.Forms]System.Windows.Forms.GroupBox GraphicsCopyright.Form1::groupBox1
      IL_02f7:  ldc.i4.0
      IL_02f8:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.GroupBox::set_TabStop(bool)
      IL_02fd:  ldarg.0
      IL_02fe:  ldfld      class [System.Windows.Forms]System.Windows.Forms.GroupBox GraphicsCopyright.Form1::groupBox1
      IL_0303:  ldarg.0
      IL_0304:  ldftn      instance void GraphicsCopyright.Form1::groupBox1_Enter(object,
                                                                                  class [mscorlib]System.EventArgs)
      IL_030a:  newobj     instance void [mscorlib]System.EventHandler::.ctor(object,
                                                                              native unsigned int)
      IL_030f:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.Control::add_Enter(class [mscorlib]System.EventHandler)
      IL_0314:  ldarg.0
      IL_0315:  ldc.i4.5
      IL_0316:  ldc.i4.s   13
      IL_0318:  newobj     instance void [System.Drawing]System.Drawing.Size::.ctor(int32,
                                                                                    int32)
      IL_031d:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.Form::set_AutoScaleBaseSize(valuetype [System.Drawing]System.Drawing.Size)
      IL_0322:  ldarg.0
      IL_0323:  ldc.i4     0x118
      IL_0328:  ldc.i4     0xa9
      IL_032d:  newobj     instance void [System.Drawing]System.Drawing.Size::.ctor(int32,
                                                                                    int32)
      IL_0332:  call       instance void [System.Windows.Forms]System.Windows.Forms.Form::set_ClientSize(valuetype [System.Drawing]System.Drawing.Size)
      IL_0337:  ldarg.0
      IL_0338:  call       instance class [System.Windows.Forms]System.Windows.Forms.Control/ControlCollection [System.Windows.Forms]System.Windows.Forms.Control::get_Controls()
      IL_033d:  ldc.i4.3
      IL_033e:  newarr     [System.Windows.Forms]System.Windows.Forms.Control
      IL_0343:  stloc.s    CS$00000002$00000004
      IL_0345:  ldloc.s    CS$00000002$00000004
      IL_0347:  ldc.i4.0
      IL_0348:  ldarg.0
      IL_0349:  ldfld      class [System.Windows.Forms]System.Windows.Forms.ProgressBar GraphicsCopyright.Form1::progressBar1
      IL_034e:  stelem.ref
      IL_034f:  ldloc.s    CS$00000002$00000004
      IL_0351:  ldc.i4.1
      IL_0352:  ldarg.0
      IL_0353:  ldfld      class [System.Windows.Forms]System.Windows.Forms.PictureBox GraphicsCopyright.Form1::pictureBox1
      IL_0358:  stelem.ref
      IL_0359:  ldloc.s    CS$00000002$00000004
      IL_035b:  ldc.i4.2
      IL_035c:  ldarg.0
      IL_035d:  ldfld      class [System.Windows.Forms]System.Windows.Forms.GroupBox GraphicsCopyright.Form1::groupBox1
      IL_0362:  stelem.ref
      IL_0363:  ldloc.s    CS$00000002$00000004
      IL_0365:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.Control/ControlCollection::AddRange(class [System.Windows.Forms]System.Windows.Forms.Control[])
      IL_036a:  ldarg.0
      IL_036b:  ldarg.0
      IL_036c:  ldfld      class [System.Windows.Forms]System.Windows.Forms.MainMenu GraphicsCopyright.Form1::mainMenu1
      IL_0371:  call       instance void [System.Windows.Forms]System.Windows.Forms.Form::set_Menu(class [System.Windows.Forms]System.Windows.Forms.MainMenu)
      IL_0376:  ldarg.0
      IL_0377:  ldstr      "Form1"
      IL_037c:  call       instance void [System.Windows.Forms]System.Windows.Forms.Control::set_Name(string)
      IL_0381:  ldarg.0
      IL_0382:  ldstr      "Graphics Copyright"
      IL_0387:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.Control::set_Text(string)
      IL_038c:  ldarg.0
      IL_038d:  ldfld      class [System.Windows.Forms]System.Windows.Forms.GroupBox GraphicsCopyright.Form1::groupBox1
      IL_0392:  ldc.i4.0
      IL_0393:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.Control::ResumeLayout(bool)
      IL_0398:  ldarg.0
      IL_0399:  ldc.i4.0
      IL_039a:  call       instance void [System.Windows.Forms]System.Windows.Forms.Control::ResumeLayout(bool)
      IL_039f:  ret
    } // end of method Form1::InitializeComponent

    .method private hidebysig static void 
            Main() cil managed
    {
      .entrypoint
      .custom instance void [mscorlib]System.STAThreadAttribute::.ctor() = ( 01 00 00 00 ) 
      // Code size       11 (0xb)
      .maxstack  8
      IL_0000:  newobj     instance void GraphicsCopyright.Form1::.ctor()
      IL_0005:  call       void [System.Windows.Forms]System.Windows.Forms.Application::Run(class [System.Windows.Forms]System.Windows.Forms.Form)
      IL_000a:  ret
    } // end of method Form1::Main

    .method private hidebysig instance void 
            menuItem2_Click(object sender,
                            class [mscorlib]System.EventArgs e) cil managed
    {
      // Code size       124 (0x7c)
      .maxstack  5
      .locals ([0] class [System.Windows.Forms]System.Windows.Forms.OpenFileDialog openFileDialog1,
               [1] class [System.Drawing]System.Drawing.Image ithumbnail,
               [2] class [System.Drawing]System.Drawing.Graphics tg,
               [3] native int CS$00000002$00000000)
      IL_0000:  newobj     instance void [System.Windows.Forms]System.Windows.Forms.OpenFileDialog::.ctor()
      IL_0005:  stloc.0
      IL_0006:  ldloc.0
      IL_0007:  ldstr      "c:\\"
      IL_000c:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.FileDialog::set_InitialDirectory(string)
      IL_0011:  ldloc.0
      IL_0012:  ldstr      "All files (*.*)|*.*"
      IL_0017:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.FileDialog::set_Filter(string)
      IL_001c:  ldloc.0
      IL_001d:  ldc.i4.2
      IL_001e:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.FileDialog::set_FilterIndex(int32)
      IL_0023:  ldloc.0
      IL_0024:  ldc.i4.1
      IL_0025:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.FileDialog::set_RestoreDirectory(bool)
      IL_002a:  ldloc.0
      IL_002b:  callvirt   instance valuetype [System.Windows.Forms]System.Windows.Forms.DialogResult [System.Windows.Forms]System.Windows.Forms.CommonDialog::ShowDialog()
      IL_0030:  ldc.i4.1
      IL_0031:  bne.un.s   IL_007b

      IL_0033:  ldarg.0
      IL_0034:  ldloc.0
      IL_0035:  callvirt   instance string [System.Windows.Forms]System.Windows.Forms.FileDialog::get_FileName()
      IL_003a:  callvirt   instance string [mscorlib]System.String::ToString()
      IL_003f:  call       class [System.Drawing]System.Drawing.Image [System.Drawing]System.Drawing.Image::FromFile(string)
      IL_0044:  stfld      class [System.Drawing]System.Drawing.Image GraphicsCopyright.Form1::originalimage
      IL_0049:  ldarg.0
      IL_004a:  ldfld      class [System.Drawing]System.Drawing.Image GraphicsCopyright.Form1::originalimage
      IL_004f:  ldc.i4.s   100
      IL_0051:  ldc.i4.s   100
      IL_0053:  ldnull
      IL_0054:  ldloca.s   CS$00000002$00000000
      IL_0056:  initobj    [mscorlib]System.IntPtr
      IL_005c:  ldloc.3
      IL_005d:  callvirt   instance class [System.Drawing]System.Drawing.Image [System.Drawing]System.Drawing.Image::GetThumbnailImage(int32,
                                                                                                                                       int32,
                                                                                                                                       class [System.Drawing]System.Drawing.Image/GetThumbnailImageAbort,
                                                                                                                                       native int)
      IL_0062:  stloc.1
      IL_0063:  ldarg.0
      IL_0064:  ldfld      class [System.Drawing]System.Drawing.Image GraphicsCopyright.Form1::originalimage
      IL_0069:  call       class [System.Drawing]System.Drawing.Graphics [System.Drawing]System.Drawing.Graphics::FromImage(class [System.Drawing]System.Drawing.Image)
      IL_006e:  stloc.2
      IL_006f:  ldarg.0
      IL_0070:  ldfld      class [System.Windows.Forms]System.Windows.Forms.PictureBox GraphicsCopyright.Form1::pictureBox1
      IL_0075:  ldloc.1
      IL_0076:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.PictureBox::set_Image(class [System.Drawing]System.Drawing.Image)
      IL_007b:  ret
    } // end of method Form1::menuItem2_Click

    .method private hidebysig instance void 
            groupBox1_Enter(object sender,
                            class [mscorlib]System.EventArgs e) cil managed
    {
      // Code size       2 (0x2)
      .maxstack  8
      IL_0000:  nop
      IL_0001:  ret
    } // end of method Form1::groupBox1_Enter

    .method private hidebysig instance void 
            button1_Click(object sender,
                          class [mscorlib]System.EventArgs e) cil managed
    {
      // Code size       658 (0x292)
      .maxstack  6
      .locals ([0] int32 imagewidth,
               [1] int32 imageheight,
               [2] int32 fontsize,
               [3] int32 x,
               [4] int32 y,
               [5] int32 a,
               [6] int32 re,
               [7] int32 gr,
               [8] int32 bl,
               [9] int32 x1,
               [10] int32 y1,
               [11] int32 z1,
               [12] int32 size,
               [13] class [System.Drawing]System.Drawing.Bitmap pattern,
               [14] valuetype [System.Drawing]System.Drawing.SizeF sizeofstring,
               [15] bool foundfont,
               [16] class [System.Drawing]System.Drawing.Bitmap temp,
               [17] class [System.Drawing]System.Drawing.Graphics g,
               [18] class [System.Drawing]System.Drawing.Graphics tempg,
               [19] class [System.Drawing]System.Drawing.Font fc,
               [20] valuetype [System.Drawing]System.Drawing.Color CS$00000002$00000000,
               [21] valuetype [System.Drawing]System.Drawing.Color CS$00000002$00000001,
               [22] valuetype [System.Drawing]System.Drawing.Color CS$00000002$00000002,
               [23] valuetype [System.Drawing]System.Drawing.Color CS$00000002$00000003,
               [24] valuetype [System.Drawing]System.Drawing.Color CS$00000002$00000004,
               [25] valuetype [System.Drawing]System.Drawing.Color CS$00000002$00000005)
      IL_0000:  ldc.i4     0x12c
      IL_0005:  stloc.2
      IL_0006:  ldarg.0
      IL_0007:  ldfld      class [System.Drawing]System.Drawing.Image GraphicsCopyright.Form1::originalimage
      IL_000c:  callvirt   instance int32 [System.Drawing]System.Drawing.Image::get_Width()
      IL_0011:  stloc.0
      IL_0012:  ldarg.0
      IL_0013:  ldfld      class [System.Drawing]System.Drawing.Image GraphicsCopyright.Form1::originalimage
      IL_0018:  callvirt   instance int32 [System.Drawing]System.Drawing.Image::get_Height()
      IL_001d:  stloc.1
      IL_001e:  ldloc.0
      IL_001f:  ldloc.1
      IL_0020:  mul
      IL_0021:  stloc.s    size
      IL_0023:  ldloc.0
      IL_0024:  ldloc.1
      IL_0025:  newobj     instance void [System.Drawing]System.Drawing.Bitmap::.ctor(int32,
                                                                                      int32)
      IL_002a:  stloc.s    pattern
      IL_002c:  ldarg.0
      IL_002d:  ldfld      class [System.Drawing]System.Drawing.Image GraphicsCopyright.Form1::originalimage
      IL_0032:  newobj     instance void [System.Drawing]System.Drawing.Bitmap::.ctor(class [System.Drawing]System.Drawing.Image)
      IL_0037:  stloc.s    temp
      IL_0039:  ldloc.s    pattern
      IL_003b:  call       class [System.Drawing]System.Drawing.Graphics [System.Drawing]System.Drawing.Graphics::FromImage(class [System.Drawing]System.Drawing.Image)
      IL_0040:  stloc.s    g
      IL_0042:  ldarg.0
      IL_0043:  ldfld      class [System.Drawing]System.Drawing.Image GraphicsCopyright.Form1::originalimage
      IL_0048:  call       class [System.Drawing]System.Drawing.Graphics [System.Drawing]System.Drawing.Graphics::FromImage(class [System.Drawing]System.Drawing.Image)
      IL_004d:  stloc.s    tempg
      IL_004f:  ldc.i4.0
      IL_0050:  stloc.s    foundfont
      IL_0052:  ldloc.s    g
      IL_0054:  call       valuetype [System.Drawing]System.Drawing.Color [System.Drawing]System.Drawing.Color::get_White()
      IL_0059:  callvirt   instance void [System.Drawing]System.Drawing.Graphics::Clear(valuetype [System.Drawing]System.Drawing.Color)
      IL_005e:  br.s       IL_00d7

      IL_0060:  ldstr      "Georgia"
      IL_0065:  ldloc.2
      IL_0066:  conv.r4
      IL_0067:  ldc.i4.1
      IL_0068:  newobj     instance void [System.Drawing]System.Drawing.Font::.ctor(string,
                                                                                    float32,
                                                                                    valuetype [System.Drawing]System.Drawing.FontStyle)
      IL_006d:  stloc.s    fc
      IL_006f:  ldloca.s   sizeofstring
      IL_0071:  ldloc.0
      IL_0072:  conv.r4
      IL_0073:  ldloc.1
      IL_0074:  conv.r4
      IL_0075:  call       instance void [System.Drawing]System.Drawing.SizeF::.ctor(float32,
                                                                                     float32)
      IL_007a:  ldloc.s    g
      IL_007c:  ldstr      "DOTNET"
      IL_0081:  ldloc.s    fc
      IL_0083:  callvirt   instance valuetype [System.Drawing]System.Drawing.SizeF [System.Drawing]System.Drawing.Graphics::MeasureString(string,
                                                                                                                                          class [System.Drawing]System.Drawing.Font)
      IL_0088:  stloc.s    sizeofstring
      IL_008a:  ldloca.s   sizeofstring
      IL_008c:  call       instance float32 [System.Drawing]System.Drawing.SizeF::get_Width()
      IL_0091:  ldloc.s    pattern
      IL_0093:  callvirt   instance int32 [System.Drawing]System.Drawing.Image::get_Width()
      IL_0098:  conv.r4
      IL_0099:  bge.un.s   IL_00d3

      IL_009b:  ldloca.s   sizeofstring
      IL_009d:  call       instance float32 [System.Drawing]System.Drawing.SizeF::get_Height()
      IL_00a2:  ldloc.s    pattern
      IL_00a4:  callvirt   instance int32 [System.Drawing]System.Drawing.Image::get_Height()
      IL_00a9:  conv.r4
      IL_00aa:  bge.un.s   IL_00d1

      IL_00ac:  ldc.i4.1
      IL_00ad:  stloc.s    foundfont
      IL_00af:  ldloc.s    g
      IL_00b1:  ldstr      "DOTNET"
      IL_00b6:  ldloc.s    fc
      IL_00b8:  call       valuetype [System.Drawing]System.Drawing.Color [System.Drawing]System.Drawing.Color::get_Black()
      IL_00bd:  newobj     instance void [System.Drawing]System.Drawing.SolidBrush::.ctor(valuetype [System.Drawing]System.Drawing.Color)
      IL_00c2:  ldc.r4     1.
      IL_00c7:  ldc.r4     1.
      IL_00cc:  callvirt   instance void [System.Drawing]System.Drawing.Graphics::DrawString(string,
                                                                                             class [System.Drawing]System.Drawing.Font,
                                                                                             class [System.Drawing]System.Drawing.Brush,
                                                                                             float32,
                                                                                             float32)
      IL_00d1:  br.s       IL_00d7

      IL_00d3:  ldloc.2
      IL_00d4:  ldc.i4.1
      IL_00d5:  sub
      IL_00d6:  stloc.2
      IL_00d7:  ldloc.s    foundfont
      IL_00d9:  brfalse.s  IL_0060

      IL_00db:  ldarg.0
      IL_00dc:  ldfld      class [System.Windows.Forms]System.Windows.Forms.ProgressBar GraphicsCopyright.Form1::progressBar1
      IL_00e1:  ldc.i4.1
      IL_00e2:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.ProgressBar::set_Minimum(int32)
      IL_00e7:  ldarg.0
      IL_00e8:  ldfld      class [System.Windows.Forms]System.Windows.Forms.ProgressBar GraphicsCopyright.Form1::progressBar1
      IL_00ed:  ldloc.s    size
      IL_00ef:  callvirt   instance void [System.Windows.Forms]System.Windows.Forms.ProgressBar::set_Maximum(int32)
      IL_00f4:  ldstr      "Creating new graphic"
      IL_00f9:  ldstr      "GraphicsCopyright"
      IL_00fe:  call       valuetype [System.Windows.Forms]System.Windows.Forms.DialogResult [System.Windows.Forms]System.Windows.Forms.MessageBox::Show(string,
                                                                                                                                                         string)
      IL_0103:  pop
      IL_0104:  ldc.i4.1
      IL_0105:  stloc.3
      IL_0106:  br         IL_0257

      IL_010b:  ldc.i4.1
      IL_010c:  stloc.s    y
      IL_010e:  br         IL_0245

      IL_0113:  ldloc.s    pattern
      IL_0115:  ldloc.3
      IL_0116:  ldloc.s    y
      IL_0118:  callvirt   instance valuetype [System.Drawing]System.Drawing.Color [System.Drawing]System.Drawing.Bitmap::GetPixel(int32,
                                                                                                                                   int32)
      IL_011d:  stloc.s    CS$00000002$00000000
      IL_011f:  ldloca.s   CS$00000002$00000000
      IL_0121:  call       instance int32 [System.Drawing]System.Drawing.Color::ToArgb()
      IL_0126:  call       valuetype [System.Drawing]System.Drawing.Color [System.Drawing]System.Drawing.Color::get_Black()
      IL_012b:  stloc.s    CS$00000002$00000001
      IL_012d:  ldloca.s   CS$00000002$00000001
      IL_012f:  call       instance int32 [System.Drawing]System.Drawing.Color::ToArgb()
      IL_0134:  bne.un     IL_023f

      IL_0139:  ldloc.s    temp
      IL_013b:  ldloc.3
      IL_013c:  ldloc.s    y
      IL_013e:  callvirt   instance valuetype [System.Drawing]System.Drawing.Color [System.Drawing]System.Drawing.Bitmap::GetPixel(int32,
                                                                                                                                   int32)
      IL_0143:  stloc.s    CS$00000002$00000002
      IL_0145:  ldloca.s   CS$00000002$00000002
      IL_0147:  call       instance unsigned int8 [System.Drawing]System.Drawing.Color::get_A()
      IL_014c:  stloc.s    a
      IL_014e:  ldloc.s    temp
      IL_0150:  ldloc.3
      IL_0151:  ldloc.s    y
      IL_0153:  callvirt   instance valuetype [System.Drawing]System.Drawing.Color [System.Drawing]System.Drawing.Bitmap::GetPixel(int32,
                                                                                                                                   int32)
      IL_0158:  stloc.s    CS$00000002$00000003
      IL_015a:  ldloca.s   CS$00000002$00000003
      IL_015c:  call       instance unsigned int8 [System.Drawing]System.Drawing.Color::get_R()
      IL_0161:  stloc.s    re
      IL_0163:  ldloc.s    temp
      IL_0165:  ldloc.3
      IL_0166:  ldloc.s    y
      IL_0168:  callvirt   instance valuetype [System.Drawing]System.Drawing.Color [System.Drawing]System.Drawing.Bitmap::GetPixel(int32,
                                                                                                                                   int32)
      IL_016d:  stloc.s    CS$00000002$00000004
      IL_016f:  ldloca.s   CS$00000002$00000004
      IL_0171:  call       instance unsigned int8 [System.Drawing]System.Drawing.Color::get_G()
      IL_0176:  stloc.s    gr
      IL_0178:  ldloc.s    temp
      IL_017a:  ldloc.3
      IL_017b:  ldloc.s    y
      IL_017d:  callvirt   instance valuetype [System.Drawing]System.Drawing.Color [System.Drawing]System.Drawing.Bitmap::GetPixel(int32,
                                                                                                                                   int32)
      IL_0182:  stloc.s    CS$00000002$00000005
      IL_0184:  ldloca.s   CS$00000002$00000005
      IL_0186:  call       instance unsigned int8 [System.Drawing]System.Drawing.Color::get_B()
      IL_018b:  stloc.s    bl
      IL_018d:  ldloc.s    re
      IL_018f:  stloc.s    x1
      IL_0191:  ldloc.s    gr
      IL_0193:  stloc.s    y1
      IL_0195:  ldloc.s    bl
      IL_0197:  stloc.s    z1
      IL_0199:  ldloc.s    bl
      IL_019b:  ldc.i4.s   25
      IL_019d:  add
      IL_019e:  ldc.i4     0xff
      IL_01a3:  bge.s      IL_01ac

      IL_01a5:  ldloc.s    bl
      IL_01a7:  ldc.i4.s   25
      IL_01a9:  add
      IL_01aa:  stloc.s    bl
      IL_01ac:  ldloc.s    gr
      IL_01ae:  ldc.i4.s   25
      IL_01b0:  add
      IL_01b1:  ldc.i4     0xff
      IL_01b6:  bge.s      IL_01bf

      IL_01b8:  ldloc.s    gr
      IL_01ba:  ldc.i4.s   25
      IL_01bc:  add
      IL_01bd:  stloc.s    gr
      IL_01bf:  ldloc.s    re
      IL_01c1:  ldc.i4.s   25
      IL_01c3:  add
      IL_01c4:  ldc.i4     0xff
      IL_01c9:  bge.s      IL_01d2

      IL_01cb:  ldloc.s    re
      IL_01cd:  ldc.i4.s   25
      IL_01cf:  add
      IL_01d0:  stloc.s    re
      IL_01d2:  ldloc.s    x1
      IL_01d4:  ldc.i4.s   25
      IL_01d6:  sub
      IL_01d7:  ldc.i4.0
      IL_01d8:  ble.s      IL_01e1

      IL_01da:  ldloc.s    x1
      IL_01dc:  ldc.i4.s   25
      IL_01de:  sub
      IL_01df:  stloc.s    x1
      IL_01e1:  ldloc.s    y1
      IL_01e3:  ldc.i4.s   25
      IL_01e5:  sub
      IL_01e6:  ldc.i4.0
      IL_01e7:  ble.s      IL_01f0

      IL_01e9:  ldloc.s    y1
      IL_01eb:  ldc.i4.s   25
      IL_01ed:  sub
      IL_01ee:  stloc.s    y1
      IL_01f0:  ldloc.s    z1
      IL_01f2:  ldc.i4.s   25
      IL_01f4:  sub
      IL_01f5:  ldc.i4.0
      IL_01f6:  ble.s      IL_01ff

      IL_01f8:  ldloc.s    z1
      IL_01fa:  ldc.i4.s   25
      IL_01fc:  sub
      IL_01fd:  stloc.s    z1
      IL_01ff:  ldloc.s    tempg
      IL_0201:  call       valuetype [System.Drawing]System.Drawing.Color [System.Drawing]System.Drawing.Color::get_Black()
      IL_0206:  newobj     instance void [System.Drawing]System.Drawing.SolidBrush::.ctor(valuetype [System.Drawing]System.Drawing.Color)
      IL_020b:  newobj     instance void [System.Drawing]System.Drawing.Pen::.ctor(class [System.Drawing]System.Drawing.Brush)
      IL_0210:  ldloc.3
      IL_0211:  ldloc.s    y
      IL_0213:  ldc.i4.1
      IL_0214:  add
      IL_0215:  ldc.i4.3
      IL_0216:  ldc.i4.3
      IL_0217:  callvirt   instance void [System.Drawing]System.Drawing.Graphics::DrawEllipse(class [System.Drawing]System.Drawing.Pen,
                                                                                              int32,
                                                                                              int32,
                                                                                              int32,
                                                                                              int32)
      IL_021c:  ldloc.s    tempg
      IL_021e:  ldloc.s    a
      IL_0220:  ldloc.s    x1
      IL_0222:  ldloc.s    y1
      IL_0224:  ldloc.s    z1
      IL_0226:  call       valuetype [System.Drawing]System.Drawing.Color [System.Drawing]System.Drawing.Color::FromArgb(int32,
                                                                                                                         int32,
                                                                                                                         int32,
                                                                                                                         int32)
      IL_022b:  newobj     instance void [System.Drawing]System.Drawing.SolidBrush::.ctor(valuetype [System.Drawing]System.Drawing.Color)
      IL_0230:  newobj     instance void [System.Drawing]System.Drawing.Pen::.ctor(class [System.Drawing]System.Drawing.Brush)
      IL_0235:  ldloc.3
      IL_0236:  ldloc.s    y
      IL_0238:  ldc.i4.1
      IL_0239:  ldc.i4.1
      IL_023a:  callvirt   instance void [System.Drawing]System.Drawing.Graphics::DrawEllipse(class [System.Drawing]System.Drawing.Pen,
                                                                                              int32,
                                                                                              int32,
                                                                                              int32,
                                                                                              int32)
      IL_023f:  ldloc.s    y
      IL_0241:  ldc.i4.1
      IL_0242:  add
      IL_0243:  stloc.s    y
      IL_0245:  ldloc.s    y
      IL_0247:  ldloc.s    pattern
      IL_0249:  callvirt   instance int32 [System.Drawing]System.Drawing.Image::get_Height()
      IL_024e:  blt        IL_0113

      IL_0253:  ldloc.3
      IL_0254:  ldc.i4.1
      IL_0255:  add
      IL_0256:  stloc.3
      IL_0257:  ldloc.3
      IL_0258:  ldloc.s    pattern
      IL_025a:  callvirt   instance int32 [System.Drawing]System.Drawing.Image::get_Width()
      IL_025f:  blt        IL_010b

      IL_0264:  ldstr      "Output file is c:\\output.jpeg"
      IL_0269:  ldstr      "GraphicsCopyright"
      IL_026e:  call       valuetype [System.Windows.Forms]System.Windows.Forms.DialogResult [System.Windows.Forms]System.Windows.Forms.MessageBox::Show(string,
                                                                                                                                                         string)
      IL_0273:  pop
      IL_0274:  ldloc.s    tempg
      IL_0276:  callvirt   instance class [System.Drawing]System.Drawing.Drawing2D.GraphicsState [System.Drawing]System.Drawing.Graphics::Save()
      IL_027b:  pop
      IL_027c:  ldarg.0
      IL_027d:  ldfld      class [System.Drawing]System.Drawing.Image GraphicsCopyright.Form1::originalimage
      IL_0282:  ldstr      "c:\\output.jpeg"
      IL_0287:  call       class [System.Drawing]System.Drawing.Imaging.ImageFormat [System.Drawing]System.Drawing.Imaging.ImageFormat::get_Jpeg()
      IL_028c:  callvirt   instance void [System.Drawing]System.Drawing.Image::Save(string,
                                                                                    class [System.Drawing]System.Drawing.Imaging.ImageFormat)
      IL_0291:  ret
    } // end of method Form1::button1_Click

  } // end of class Form1

} // end of namespace GraphicsCopyright

//*********** DISASSEMBLY COMPLETE ***********************
// WARNING: Created Win32 resource file output.res
