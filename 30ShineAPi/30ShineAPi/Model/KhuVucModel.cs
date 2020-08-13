using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace _30ShineAPi.Model
{
    public class KhuVucModel
    {
        [Key]
        public string tentp { get; set; }
        [Key]
        public string tenqh { get; set; }
    }
}
