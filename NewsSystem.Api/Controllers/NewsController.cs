namespace NewsSystem.Api.Controllers
{
    using System.Collections.Generic;
    using System.Web.Http;

    public class NewsController : ApiController
    {

        public IEnumerable<string> Get()
        {
            return new string[] { "value1", "value2" };
        }

        public string Get(int id)
        {
            return "value";
        }
    }
}
