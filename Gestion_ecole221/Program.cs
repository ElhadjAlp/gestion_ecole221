using Gestion_ecole221.Data;
using Gestion_ecole221.Fixtures;
using Gestion_ecole221.Services;
using Gestion_ecole221.Services;
using Microsoft.EntityFrameworkCore;

var builder = WebApplication.CreateBuilder(args);

// Configure the database connection string
string connectionString = builder.Configuration.GetConnectionString("MysqlConnection")!;

builder.Services.AddDbContext<ApplicationDbContext>(options =>

            options.UseMySql(connectionString,

            new MySqlServerVersion(new Version(8, 0, 40))));


// Configure the services for the application.
/* 
    AddTransient => Créer à chaque fois
    AddScoped => Créer une instance unique pour la durée de la requête
    AddSingleton => Créer une instance unique pour toute la durée de l'application
 */
builder.Services.AddScoped<IEtudiantService, EtudiantService>();

var app = builder.Build();

// Configurer le middleware
if (app.Environment.IsDevelopment())
{
    app.UseDeveloperExceptionPage();
}
else
{
    app.UseExceptionHandler("/Home/Error");
    app.UseHsts();
}

// Utiliser le routage et mapper les contrôleurs MVC
app.UseRouting();

app.UseEndpoints(endpoints =>
{
    endpoints.MapControllerRoute(
        name: "default",
        pattern: "{controller=Home}/{action=Index}/{id?}");
});

app.Run();