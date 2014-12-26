namespace NewsSystem.Api.Data
{
    using System.Collections.Generic;
    using NewsSystem.Api.Models;
    using NewsSystem.Api.Socket;

    public class NewsSocketRepository: IRepository<News>
    {
        public News Get(int id)
        {
            var request = new SocketRequest()
            {
                EntityType = "News",
                Method = "Get",
                Params = new Dictionary<string, object>()
            };
            request.Params["id"] = id;
            return SocketClient.Instance.Send<News>(request);
        }

        public IEnumerable<News> All()
        {
            var request = new SocketRequest()
            {
                EntityType = "News",
                Method = "All"
            };

            return SocketClient.Instance.Send<IEnumerable<News>>(request);
        }
    }
}