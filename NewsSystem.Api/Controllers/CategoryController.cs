namespace NewsSystem.Api.Controllers
{
    using NewsSystem.Api.Data;
    using NewsSystem.Api.Models;
    using System.Web.Http;

    public class CategoryController : ApiController
    {
        private IRepository<Category> categoryRepository;

        public CategoryController(IRepository<Category> categoryRepo)
        {
            this.categoryRepository = categoryRepo;
        }

        public IHttpActionResult Get()
        {
            var allCategories = this.categoryRepository.All();

            return Ok(allCategories);
        }

        public IHttpActionResult Get(int id)
        {
            var category = this.categoryRepository.Get(id);

            if (category == null)
            {
                return BadRequest("Category does not exist - invalid id");
            }

            return Ok(category);
        }
    }
}
