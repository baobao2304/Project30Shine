using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using _30ShineAPi.Model;

namespace _30ShineAPi.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class StylistController : ControllerBase
    {
        private readonly DataContext _context;

        public StylistController(DataContext context)
        {
            _context = context;
        }

        // GET: api/Stylist
        [HttpGet]
        public async Task<ActionResult<IEnumerable<StylistModel>>> GetStylistItems()
        {
            return await _context.stylist.ToListAsync();
        }

        // GET: api/Stylist/5
        [HttpGet("{id}")]
        public async Task<ActionResult<StylistModel>> GetStylistModel(int id)
        {
            var stylistModel = await _context.stylist.FindAsync(id);

            if (stylistModel == null)
            {
                return NotFound();
            }

            return stylistModel;
        }

        // PUT: api/Stylist/5
        // To protect from overposting attacks, enable the specific properties you want to bind to, for
        // more details, see https://go.microsoft.com/fwlink/?linkid=2123754.
        [HttpPut("{id}")]
        public async Task<IActionResult> PutStylistModel(int id, StylistModel stylistModel)
        {
            if (id != stylistModel.mastylist)
            {
                return BadRequest();
            }

            _context.Entry(stylistModel).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!StylistModelExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        // POST: api/Stylist
        // To protect from overposting attacks, enable the specific properties you want to bind to, for
        // more details, see https://go.microsoft.com/fwlink/?linkid=2123754.
        [HttpPost]
        public async Task<ActionResult<StylistModel>> PostStylistModel(StylistModel stylistModel)
        {
            _context.stylist.Add(stylistModel);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetStylistModel", new { id = stylistModel.mastylist }, stylistModel);
        }

        // DELETE: api/Stylist/5
        [HttpDelete("{id}")]
        public async Task<ActionResult<StylistModel>> DeleteStylistModel(int id)
        {
            var stylistModel = await _context.stylist.FindAsync(id);
            if (stylistModel == null)
            {
                return NotFound();
            }

            _context.stylist.Remove(stylistModel);
            await _context.SaveChangesAsync();

            return stylistModel;
        }

        private bool StylistModelExists(int id)
        {
            return _context.stylist.Any(e => e.mastylist == id);
        }
    }
}
