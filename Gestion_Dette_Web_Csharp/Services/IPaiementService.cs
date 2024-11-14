
using Gestion_Dette_Web_Csharp.Models;

namespace Cours.Services;

public interface IPaiementService{
    Task<IEnumerable<Paiement>> GetDettePaiementsAsync(int detteId);
}