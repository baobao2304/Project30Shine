using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace _30ShineAPi.Model
{
    public class SalonModel
    {
        [Key]
        public int masalon { get; set; }
        public int tentp { get; set; }
        public int tenqh { get; set; }
        public int diachi { get; set; }
    }
}
