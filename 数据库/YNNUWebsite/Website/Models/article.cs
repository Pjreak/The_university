//------------------------------------------------------------------------------
// <auto-generated>
//     此代码已从模板生成。
//
//     手动更改此文件可能导致应用程序出现意外的行为。
//     如果重新生成代码，将覆盖对此文件的手动更改。
// </auto-generated>
//------------------------------------------------------------------------------

namespace Website.Models
{
    using System;
    using System.Collections.Generic;
    
    public partial class article
    {
        public int id { get; set; }
        public int menu_id { get; set; }
        public string title { get; set; }
        public string writer { get; set; }
        public string text { get; set; }
        public System.DateTime add_time { get; set; }
        public int click { get; set; }
    
        public virtual menu menu { get; set; }
    }
}
