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
    public class KhachHangController : ControllerBase
    {
        private readonly DataContext _context;

        public KhachHangController(DataContext context)
        {
            _context = context;
        }

        // GET: api/KhachHang
        [HttpGet]
        public async Task<ActionResult<IEnumerable<KhachHangModel>>> GetKhachHang()
        {
            return await _context.KhachHang.ToListAsync();
        }

        // GET: api/KhachHang/5
        [HttpGet("{id}")]
        public async Task<ActionResult<KhachHangModel>> GetKhachHangModel(int id)
        {
            var khachHangModel = await _context.KhachHang.FindAsync(id);

            if (khachHangModel == null)
            {
                return NotFound();
            }

            return khachHangModel;
        }

        // PUT: api/KhachHang/5
        // To protect from overposting attacks, enable the specific properties you want to bind to, for
        // more details, see https://go.microsoft.com/fwlink/?linkid=2123754.
        [HttpPut("{id}")]
        public async Task<IActionResult> PutKhachHangModel(int id, KhachHangModel khachHangModel)
        {
            if (id != khachHangModel.makh)
            {
                return BadRequest();
            }

            _context.Entry(khachHangModel).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!KhachHangModelExists(id))
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

        // POST: api/KhachHang
        // To protect from overposting attacks, enable the specific properties you want to bind to, for
        // more details, see https://go.microsoft.com/fwlink/?linkid=2123754.
        [HttpPost]
        public async Task<ActionResult<KhachHangModel>> PostKhachHangModel(KhachHangModel khachHangModel)
        {
            _context.KhachHang.Add(khachHangModel);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetKhachHangModel", new { id = khachHangModel.makh }, khachHangModel);
        }

        // DELETE: api/KhachHang/5
        [HttpDelete("{id}")]
        public async Task<ActionResult<KhachHangModel>> DeleteKhachHangModel(int id)
        {
            var khachHangModel = await _context.KhachHang.FindAsync(id);
            if (khachHangModel == null)
            {
                return NotFound();
            }

            _context.KhachHang.Remove(khachHangModel);
            await _context.SaveChangesAsync();

            return khachHangModel;
        }

        private bool KhachHangModelExists(int id)
        {
            return _context.KhachHang.Any(e => e.makh == id);
        }
    }
}
