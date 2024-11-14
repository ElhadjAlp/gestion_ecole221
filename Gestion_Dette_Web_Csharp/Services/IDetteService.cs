using Gestion_Dette_Web_Csharp.Models;

namespace Cours.Services;

public interface IDetteService{
    Task<IEnumerable<Dette>> GetDettesClientAsync(int clientId);
    Task<IEnumerable<Dette>> GetDettesClientAsync(int clientId, int pageNumber, int pageSize);
    Task<int> GetTotalDettesCountAsync(int clientId);
    Task<Dette> Create(Dette Dette);
}