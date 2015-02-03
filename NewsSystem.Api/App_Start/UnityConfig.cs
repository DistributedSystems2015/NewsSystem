namespace NewsSystem.Api
{
    using System.Web.Http;
    using Microsoft.Practices.Unity;
    using NewsSystem.Api.Data;
    using NewsSystem.Api.Models;
    using Unity.WebApi;

    public static class UnityConfig
    {
        public static void RegisterComponents()
        {
            var container = new UnityContainer();

            //container.RegisterType<IRepository<News>, NewsMemoryRepository>();
            //container.RegisterType<IRepository<Category>, CategoryMemoryRepository>();
            container.RegisterType<IRepository<News>, NewsSocketRepository>();
            container.RegisterType<IRepository<Category>, CategorySocketRepository>();

            GlobalConfiguration.Configuration.DependencyResolver = new UnityDependencyResolver(container);
        }
    }
}