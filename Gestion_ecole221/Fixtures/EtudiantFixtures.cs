using Gestion_ecole221.Models;
using Gestion_ecole221.Data;
using Microsoft.EntityFrameworkCore;

namespace Gestion_ecole221.Fixtures.Data
{
    public class EtudiantFixture
    {
        private readonly ApplicationDbContext _context;

        // Constructeur qui reçoit l'instance du DbContext
        public EtudiantFixture(ApplicationDbContext context)
        {
            _context = context;
        }

        // Méthode pour ajouter des étudiants de test
        public void Seed()
        {
            // Vérifiez si des étudiants existent déjà pour éviter les doublons
            if (!_context.Etudiants.Any())
            {
                // Créer une liste d'étudiants à ajouter
                var etudiants = new List<Etudiant>
                {
                    new Etudiant { Matricule = "ETD001", NomComplet = "John Doe", Adresse = "123 Rue Exemple" },
                    new Etudiant { Matricule = "ETD002", NomComplet = "Jane Smith", Adresse = "456 Rue Test" },
                    new Etudiant { Matricule = "ETD003", NomComplet = "Pierre Dupont", Adresse = "789 Rue France" }
                };

                // Ajouter les étudiants dans le DbContext
                _context.Etudiants.AddRange(etudiants);

                // Sauvegarder les changements dans la base de données
                _context.SaveChanges();
            }
        }
    }
}
