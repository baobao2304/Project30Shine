using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace _30ShineAPi.Model
{
    public class KhachHangModel
    {
        [Key]
        public int makh { get; set; }
        public string email { get; set; }
        public string sdt { get; set; }
        public string hoten { get; set; }
        public DateTime ngaysinh { get; set; }
        public string diachi { get; set; }
        public string taikhoan { get; set; }
        public string matkhau { get; set; }
    }
}
