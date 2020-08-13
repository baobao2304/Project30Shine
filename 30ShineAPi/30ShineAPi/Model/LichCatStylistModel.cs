using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace _30ShineAPi.Model
{
    public class LichCatStylistModel
    {

        [Key]
        public int mastylist { get; set; }
        public DateTime ngay { get; set; }
        public string gio { get; set; }
    }
}
