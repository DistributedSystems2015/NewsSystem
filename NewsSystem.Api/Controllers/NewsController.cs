namespace NewsSystem.Api.Controllers
{
    using NewsSystem.Api.Data;
    using NewsSystem.Api.Models;
    using System.Collections.Generic;
    using System.Linq;
    using System.Web.Http;

    public class NewsController : ApiController
    {
        private IRepository<News> newsRepository;

        public NewsController(IRepository<News> newsRepo)
        {
            this.newsRepository = newsRepo;
        }

        [HttpGet]
        public IHttpActionResult Get()
        {
            var allNews = this.newsRepository.All();

            return Ok(allNews);
        }

        [HttpGet]
        public IHttpActionResult Get(int id)
        {
            var currentNews = this.newsRepository
                .All()
                .FirstOrDefault(n => n.Id == id); ;

            if (currentNews == null)
            {
                return BadRequest("News does not exist - invalid id");
            }

            return Ok(currentNews);
        }
    }
}
