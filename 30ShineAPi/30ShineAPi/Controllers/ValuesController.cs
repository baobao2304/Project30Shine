using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using _30ShineAPi.Model;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace _30ShineAPi.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ValuesController : ControllerBase
    {
        private readonly DataContext _context;
      
        //[HttpGet]
        //public async Task<ActionResult<IEnumerable<StylistModel>>> GetTodoItems()
        //{
        //    return await _context.StylistItems
        //        .Select(x => ItemToDTO(x))
        //        .ToListAsync();
        //}
        //private static StylistModel ItemToDTO(StylistModel todoItem) =>
        //new StylistModel
        //{
        //    mastylist = todoItem.mastylist,
        //    masalon = todoItem.masalon,
        //    name = todoItem.name,
        //    sdt = todoItem.sdt
        //};
    }
}
