using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace _30ShineAPi.Model
{
    public class StylistModel
    {
        [Key]
        public int mastylist { get; set; }

        public int masalon { get; set; }

        public String name { get; set; }
        
        public String sdt { get; set; }
    }
}
