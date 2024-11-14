using System.Diagnostics;
using Cours.Services;
using Gestion_Dette_Web_Csharp.Models;
using Microsoft.AspNetCore.Mvc;

namespace Gestion_Dette_Web_Csharp.Controllers;

public class DetteController : Controller
{
    private readonly ILogger<DetteController> _logger;
    private readonly IDetteService _detteService;


        // Définition du modèle de pagination à l'extérieur de la méthode
    public record PaginatedDetteViewModel
    {
        public required List<Dette> Dettes { get; init; }
        public int PageIndex { get; init; }
        public int TotalPages { get; init; }
        public bool HasPreviousPage { get; init; }
        public bool HasNextPage { get; init; }
        public int ClientId { get; init; }
    }

    public DetteController(ILogger<DetteController> logger, IDetteService detteService)
    {
        _logger = logger;
        _detteService = detteService;
    }

    // Affiche toutes les dettes avec pagination pour un client donné
    public async Task<IActionResult> DetteClient(int clientId, int page = 1)
    {
        const int pageSize = 5;

        // Récupération des dettes du client avec pagination
        var dettes = await _detteService.GetDettesClientAsync(clientId, page, pageSize);
        var totalDettes = await _detteService.GetTotalDettesCountAsync(clientId);
        var totalPages = (int)Math.Ceiling((decimal)totalDettes / pageSize);

        // Création du modèle de pagination
        var model = new PaginatedDetteViewModel
        {
            Dettes = dettes.ToList(),
            PageIndex = page,
            TotalPages = totalPages,
            HasPreviousPage = page > 1,
            HasNextPage = page < totalPages,
            ClientId = clientId
        };

        return View(model);
    }

    // Créer une nouvelle dette pour un client
    public IActionResult Create(int clientId)
    {
        ViewBag.ClientId = clientId;
        return View();
    }

    [HttpPost]
    [ValidateAntiForgeryToken]
    public async Task<IActionResult> Create(int clientId, [Bind("Date,Montant,MontantVerser")] Dette dette)
    {
        if (ModelState.IsValid)
        {
            dette.ClientId = clientId;
            var detteAdded = await _detteService.Create(dette);

            if (detteAdded != null)
            {
                TempData["Message"] = "Dette créée avec succès!";
                return RedirectToAction(nameof(DetteClient), new { clientId = clientId });
            }
            else
            {
                TempData["Message"] = "Erreur lors de la création de la dette.";
                return RedirectToAction(nameof(Create), new { clientId = clientId });
            }
        }
        return View(dette);
    }

    [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
    public IActionResult Error()
    {
        return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
    }
}
