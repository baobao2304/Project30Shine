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
    public class SalonController : ControllerBase
    {
        private readonly DataContext _context;

        public SalonController(DataContext context)
        {
            _context = context;
        }

        // GET: api/Salon
        [HttpGet]
        public async Task<ActionResult<IEnumerable<SalonModel>>> Getsalon()
        {
            return await _context.salon.ToListAsync();
        }

        // GET: api/Salon/5
        [HttpGet("{id}")]
        public async Task<ActionResult<SalonModel>> GetSalonModel(int id)
        {
            var salonModel = await _context.salon.FindAsync(id);

            if (salonModel == null)
            {
                return NotFound();
            }

            return salonModel;
        }

        // PUT: api/Salon/5
        // To protect from overposting attacks, enable the specific properties you want to bind to, for
        // more details, see https://go.microsoft.com/fwlink/?linkid=2123754.
        [HttpPut("{id}")]
        public async Task<IActionResult> PutSalonModel(int id, SalonModel salonModel)
        {
            if (id != salonModel.masalon)
            {
                return BadRequest();
            }

            _context.Entry(salonModel).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!SalonModelExists(id))
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

        // POST: api/Salon
        // To protect from overposting attacks, enable the specific properties you want to bind to, for
        // more details, see https://go.microsoft.com/fwlink/?linkid=2123754.
        [HttpPost]
        public async Task<ActionResult<SalonModel>> PostSalonModel(SalonModel salonModel)
        {
            _context.salon.Add(salonModel);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetSalonModel", new { id = salonModel.masalon }, salonModel);
        }

        // DELETE: api/Salon/5
        [HttpDelete("{id}")]
        public async Task<ActionResult<SalonModel>> DeleteSalonModel(int id)
        {
            var salonModel = await _context.salon.FindAsync(id);
            if (salonModel == null)
            {
                return NotFound();
            }

            _context.salon.Remove(salonModel);
            await _context.SaveChangesAsync();

            return salonModel;
        }

        private bool SalonModelExists(int id)
        {
            return _context.salon.Any(e => e.masalon == id);
        }
    }
}
