using System.Diagnostics;
using Cours.Services;
using Gestion_Dette_Web_Csharp.Models;
using Microsoft.AspNetCore.Mvc;

namespace GestionDette.Controllers;

public class ClientController : Controller
{
    private readonly ILogger<ClientController> _logger;
    private readonly IClientService _clientService;

    // Définition du modèle de pagination à l'extérieur de la méthode
    public record PaginatedClientViewModel
    {
        public required List<Client> Clients { get; init; }
        public int PageIndex { get; init; }
        public int TotalPages { get; init; }
        public bool HasPreviousPage { get; init; }
        public bool HasNextPage { get; init; }
    }

    public ClientController(ILogger<ClientController> logger, IClientService clientService)
    {
        _logger = logger;
        _clientService = clientService;
    }

    // Index - Affiche tous les clients avec pagination
    public async Task<IActionResult> Index(int page = 1)
    {
        const int pageSize = 2;

        // Appel des méthodes asynchrones avec 'await'
        var clients = await _clientService.GetClientsAsync(page, pageSize);
        var totalClients = await _clientService.GetTotalClientsCountAsync();
        var totalPages = (int)Math.Ceiling((decimal)totalClients / pageSize);

        // Création du modèle de pagination
        var model = new PaginatedClientViewModel
        {
            Clients = clients.ToList(),  // Convertir en liste si nécessaire
            PageIndex = page,
            TotalPages = totalPages,
            HasPreviousPage = page > 1,
            HasNextPage = page < totalPages
        };

        return View(model);
    }

    // Créer un nouveau client
    public IActionResult Create()
    {
        return View();
    }

    [HttpPost]
    [ValidateAntiForgeryToken]
    public async Task<IActionResult> Create([Bind("Surnom,Telephone,Adresse")] Client client)
    {
        if (ModelState.IsValid)
        {
            // Ajouter le client
            var clientAdded = await _clientService.Create(client);

            // Vérifier si l'ajout a réussi (optionnel)
            if (clientAdded != null)
            {
                TempData["Message"] = "Client créé avec succès!";
                return RedirectToAction(nameof(Index));
            }
            else
            {
                TempData["Message"] = "Erreur lors de la création du client.";
                return RedirectToAction(nameof(Create));
            }
        }
        return View(client);
    }

    [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
    public IActionResult Error()
    {
        return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
    }
}
