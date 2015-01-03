namespace NewsSystem.Api.Controllers
{
    using NewsSystem.Api.Data;
    using NewsSystem.Api.Models;
    using System.Web.Http;

    public class NewsController : ApiController
    {
        private IRepository<News> newsRepository;

        public NewsController(IRepository<News> newsRepo)
        {
            this.newsRepository = newsRepo;
        }

        public IHttpActionResult Get()
        {
            var allNews = this.newsRepository.All();

            return Ok(allNews);
        }

        public IHttpActionResult Get(int id)
        {
            var currentNews = this.newsRepository.Get(id);

            if (currentNews == null)
            {
                return BadRequest("News does not exist - invalid id");
            }

            return Ok(currentNews);
        }
    }
}
