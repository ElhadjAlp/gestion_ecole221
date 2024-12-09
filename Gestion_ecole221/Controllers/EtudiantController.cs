using Gestion_ecole221.Models;
using Gestion_ecole221.Services;
using Microsoft.AspNetCore.Mvc;

namespace Gestion_ecole221.Controllers
{
    public class EtudiantController : Controller
    {
        private readonly EtudiantService _etudiantService;

        public EtudiantController(EtudiantService etudiantService)
        {
            _etudiantService = etudiantService;
        }

        // GET: Etudiant
        public async Task<IActionResult> Index()
        {
            var etudiants = await _etudiantService.GetAllEtudiantsAsync();
            return View(etudiants);
        }

        // GET: Etudiant/Details/5
        public async Task<IActionResult> Details(int id)
        {
            var etudiant = await _etudiantService.GetEtudiantByIdAsync(id);
            if (etudiant == null)
            {
                return NotFound();
            }
            return View(etudiant);
        }

        // GET: Etudiant/Create
        public IActionResult Create()
        {
            return View();
        }

        // POST: Etudiant/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Create([Bind("Id,Matricule,NomComplet,Adresse")] Etudiant etudiant)
        {
            if (ModelState.IsValid)
            {
                await _etudiantService.AddEtudiantAsync(etudiant);
                return RedirectToAction(nameof(Index));
            }
            return View(etudiant);
        }

        // GET: Etudiant/Edit/5
        public async Task<IActionResult> Edit(int id)
        {
            var etudiant = await _etudiantService.GetEtudiantByIdAsync(id);
            if (etudiant == null)
            {
                return NotFound();
            }
            return View(etudiant);
        }

        // POST: Etudiant/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Edit(int id, [Bind("Id,Matricule,NomComplet,Adresse")] Etudiant etudiant)
        {
            if (id != etudiant.Id)
            {
                return NotFound();
            }

            if (ModelState.IsValid)
            {
                try
                {
                    await _etudiantService.UpdateEtudiantAsync(etudiant);
                }
                catch (DbUpdateConcurrencyException)
                {
                    if (!EtudiantExists(etudiant.Id))
                    {
                        return NotFound();
                    }
                    else
                    {
                        throw;
                    }
                }
                return RedirectToAction(nameof(Index));
            }
            return View(etudiant);
        }

        // GET: Etudiant/Delete/5
        public async Task<IActionResult> Delete(int id)
        {
            var etudiant = await _etudiantService.GetEtudiantByIdAsync(id);
            if (etudiant == null)
            {
                return NotFound();
            }
            return View(etudiant);
        }

        // POST: Etudiant/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> DeleteConfirmed(int id)
        {
            await _etudiantService.DeleteEtudiantAsync(id);
            return RedirectToAction(nameof(Index));
        }

        private bool EtudiantExists(int id)
        {
            return _etudiantService.GetEtudiantByIdAsync(id) != null;
        }
    }
}
