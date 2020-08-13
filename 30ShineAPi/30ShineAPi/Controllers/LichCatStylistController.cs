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
    public class LichCatStylistController : ControllerBase
    {
        private readonly DataContext _context;

        public LichCatStylistController(DataContext context)
        {
            _context = context;
        }

        // GET: api/LichCatStylist
        [HttpGet]
        public async Task<ActionResult<IEnumerable<LichCatStylistModel>>> Getlichcat_stylist()
        {
            return await _context.lichcat_stylist.ToListAsync();
        }

        // GET: api/LichCatStylist/5
        [HttpGet("{id}")]
        public async Task<ActionResult<LichCatStylistModel>> GetLichCatStylistModel(int id)
        {
            var lichCatStylistModel = await _context.lichcat_stylist.FindAsync(id);

            if (lichCatStylistModel == null)
            {
                return NotFound();
            }

            return lichCatStylistModel;
        }

        // PUT: api/LichCatStylist/5
        // To protect from overposting attacks, enable the specific properties you want to bind to, for
        // more details, see https://go.microsoft.com/fwlink/?linkid=2123754.
        [HttpPut("{id}")]
        public async Task<IActionResult> PutLichCatStylistModel(int id, LichCatStylistModel lichCatStylistModel)
        {
            if (id != lichCatStylistModel.mastylist)
            {
                return BadRequest();
            }

            _context.Entry(lichCatStylistModel).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!LichCatStylistModelExists(id))
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

        // POST: api/LichCatStylist
        // To protect from overposting attacks, enable the specific properties you want to bind to, for
        // more details, see https://go.microsoft.com/fwlink/?linkid=2123754.
        [HttpPost]
        public async Task<ActionResult<LichCatStylistModel>> PostLichCatStylistModel(LichCatStylistModel lichCatStylistModel)
        {
            _context.lichcat_stylist.Add(lichCatStylistModel);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetLichCatStylistModel", new { id = lichCatStylistModel.mastylist }, lichCatStylistModel);
        }

        // DELETE: api/LichCatStylist/5
        [HttpDelete("{id}")]
        public async Task<ActionResult<LichCatStylistModel>> DeleteLichCatStylistModel(int id)
        {
            var lichCatStylistModel = await _context.lichcat_stylist.FindAsync(id);
            if (lichCatStylistModel == null)
            {
                return NotFound();
            }

            _context.lichcat_stylist.Remove(lichCatStylistModel);
            await _context.SaveChangesAsync();

            return lichCatStylistModel;
        }

        private bool LichCatStylistModelExists(int id)
        {
            return _context.lichcat_stylist.Any(e => e.mastylist == id);
        }
    }
}
