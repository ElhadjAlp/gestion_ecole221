using Microsoft.EntityFrameworkCore;
using Gestion_ecole221.Models; // Assurez-vous que l'entité Etudiant est dans ce namespace

namespace Gestion_ecole221.Data.Data
{
    public class ApplicationDbContext : DbContext
    {
        // Le constructeur permet de passer les options de configuration à la classe DbContext
        public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options) : base(options) { }

        // Méthode pour configurer le modèle et les relations
        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            // Si vous avez des configurations spécifiques ou des relations entre les entités à définir, vous pouvez les ajouter ici
            // Par exemple, si vous avez une relation entre Etudiant et une autre entité comme Dette

            modelBuilder.Entity<Etudiant>()
                .ToTable("Etudiants"); // Spécifie le nom de la table (optionnel, si vous voulez personnaliser)
        }

        // DbSet pour l'entité Etudiant
        public DbSet<Etudiant> Etudiants { get; set; } // Cette propriété représente la table 'Etudiants' dans la base de données

        // Vous pouvez ajouter d'autres DbSet pour d'autres entités (comme Dette, Paiement, etc.) si nécessaire
        // public DbSet<AutreEntite> AutreEntites { get; set; }
    }
}
