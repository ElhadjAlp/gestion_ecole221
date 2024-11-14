using Gestion_Dette_Web_Csharp.Data;
using Gestion_Dette_Web_Csharp.Models;
using Microsoft.EntityFrameworkCore;

namespace Cours.Services.Impl;

public class DetteService : IDetteService
{

    private readonly ApplicationDbContext _context;

    public DetteService(ApplicationDbContext context)
    {
        this._context = context;
    }
    public async Task<IEnumerable<Dette>> GetDettesClientAsync(int clientId)
    {
        return await _context.Dettes
        .Where(dette => dette.ClientId == clientId)
        .ToListAsync();
    }
     // Méthode pour obtenir les dettes d'un client avec pagination
    public async Task<IEnumerable<Dette>> GetDettesClientAsync(int clientId, int pageNumber, int pageSize)
    {
        return await _context.Dettes
            .Where(dette => dette.ClientId == clientId)
            .Skip((pageNumber - 1) * pageSize) // Sauter les dettes des pages précédentes
            .Take(pageSize) // Limiter le nombre de dettes par page
            .ToListAsync();
    }

    // Méthode pour obtenir le nombre total de dettes pour un client
    public async Task<int> GetTotalDettesCountAsync(int clientId)
    {
        return await _context.Dettes
            .CountAsync(dette => dette.ClientId == clientId);
    }

    // // Méthode pour obtenir les dettes d'un client spécifique
    // public async Task<IEnumerable<Dette>> GetDettesClientAsync(int clientId)
    // {
    //     return await _context.Dettes
    //         .Where(dette => dette.ClientId == clientId)
    //         .Include(d => d.Paiements) // Inclure les paiements associés si nécessaire
    //         .ToListAsync();
    // }

    // Méthode pour créer une nouvelle dette
    public async Task<Dette> Create(Dette Dette)
    {
        _context.Dettes.Add(Dette); // Ajoute la dette au contexte
        await _context.SaveChangesAsync();   // Sauvegarde les changements dans la base de données
        return Dette;                // Retourne la dette créée
    }
}