using Gestion_Dette_Web_Csharp.Models;

namespace Cours.Services
{
    public interface IClientService
    {
        Task<IEnumerable<Client>> GetClientsAsync(int pageNumber, int pageSize);
        Task<Client> Create(Client client);
        Task<int> GetTotalClientsCountAsync();
    }
}
