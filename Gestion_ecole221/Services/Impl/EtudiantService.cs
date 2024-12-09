using Gestion_ecole221.Models;
using Gestion_ecole221.Data;
using Microsoft.EntityFrameworkCore;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace Gestion_ecole221.Services
{
    public class EtudiantService : IEtudiantService
    {
        private readonly ApplicationDbContext _context;

        public EtudiantService(ApplicationDbContext context)
        {
            _context = context;
        }

        public async Task AddEtudiantAsync(Etudiant etudiant)
        {
            _context.Etudiants.Add(etudiant);
            await _context.SaveChangesAsync();
        }

        public async Task<List<Etudiant>> GetAllEtudiantsAsync()
        {
            return await _context.Etudiants.ToListAsync();
        }

        public async Task<Etudiant> GetEtudiantByIdAsync(int id)
        {
            return await _context.Etudiants.FindAsync(id);
        }

        public async Task UpdateEtudiantAsync(Etudiant etudiant)
        {
            _context.Etudiants.Update(etudiant);
            await _context.SaveChangesAsync();
        }

        public async Task DeleteEtudiantAsync(int id)
        {
            var etudiant = await _context.Etudiants.FindAsync(id);
            if (etudiant != null)
            {
                _context.Etudiants.Remove(etudiant);
                await _context.SaveChangesAsync();
            }
        }
    }
}
