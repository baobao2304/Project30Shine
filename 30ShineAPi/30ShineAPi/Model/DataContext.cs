using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace _30ShineAPi.Model
{
    public class DataContext : DbContext
    {
        public DataContext()
        {

        }
        public DataContext(DbContextOptions<DataContext> options)
            : base(options)
        {
        }

        public DbSet<StylistModel> stylist { get; set; }
        public DbSet<KhachHangModel> KhachHang { get; set; }
        public DbSet<LichCatStylistModel> lichcat_stylist { get; set; }
        public DbSet<SalonModel> salon { get; set; }
        public DbSet<KhuVucModel> khuvuc { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            if (!optionsBuilder.IsConfigured)
            {
                optionsBuilder.UseSqlServer("Server = DESKTOP - T572L83\\SQLEXPRESS; Database = QL_Salon30Shines; Trusted_Connection = True; User ID = baobao2304; Password = 123456789");
            }
        }
    }
}
