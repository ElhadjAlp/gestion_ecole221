using Gestion_Dette_Web_Csharp.Data;
using Gestion_Dette_Web_Csharp.Models;
using Microsoft.EntityFrameworkCore;

namespace Cours.Services.Impl
{
    public class ClientService : IClientService
    {
        private readonly ApplicationDbContext _context;

        public ClientService(ApplicationDbContext context)
        {
            this._context = context;
        }

        // Méthode pour créer un client
        public async Task<Client> Create(Client client)
        {
            _context.Clients.Add(client);
            await _context.SaveChangesAsync();
            return client;
        }

        // Méthode pour obtenir les clients avec pagination
        public async Task<IEnumerable<Client>> GetClientsAsync(int pageNumber, int pageSize)
        {
            return await _context.Clients
                .Skip((pageNumber - 1) * pageSize)  // Sauter les clients des pages précédentes
                .Take(pageSize)  // Limiter le nombre de clients par page
                .ToListAsync();
        }

        // Méthode pour obtenir le nombre total de clients
        public async Task<int> GetTotalClientsCountAsync()
        {
            return await _context.Clients.CountAsync();
        }
    }
}
