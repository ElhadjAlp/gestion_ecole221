using Gestion_ecole221.Models;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace Gestion_ecole221.Services
{
    public interface IEtudiantService
    {
        Task AddEtudiantAsync(Etudiant etudiant);
        Task<List<Etudiant>> GetAllEtudiantsAsync();
        Task<Etudiant> GetEtudiantByIdAsync(int id);
        Task UpdateEtudiantAsync(Etudiant etudiant);
        Task DeleteEtudiantAsync(int id);
    }
}
