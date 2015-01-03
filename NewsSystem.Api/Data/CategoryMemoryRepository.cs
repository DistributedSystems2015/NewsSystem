namespace NewsSystem.Api.Data
{
    using System.Collections.Generic;
    using System.Linq;
    using NewsSystem.Api.Models;

    internal class CategoryMemoryRepository : IRepository<Category>
    {
        private IEnumerable<Category> categories = new Category[]
        {
            new Category() { Id = 1, Name = "IT news" },
            new Category() { Id = 2, Name = "Hardware" }
        };

        public Category Get(int id)
        {
            return this.categories.FirstOrDefault(item => item.Id == id);
        }

        public IEnumerable<Category> All()
        {
            return this.categories;
        }
    }
}