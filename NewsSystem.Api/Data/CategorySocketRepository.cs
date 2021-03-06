﻿namespace NewsSystem.Api.Data
{
    using System.Collections.Generic;
    using NewsSystem.Api.Models;
    using NewsSystem.Api.Socket;

    public class CategorySocketRepository : IRepository<Category>
    {
        public Category Get(int id)
        {
            var request = new SocketRequest()
            {
                EntityType = "Category",
                Method = "Get",
                Params = new Dictionary<string, object>()
            };
            request.Params["id"] = id;
            return SocketClient.Instance.Send<Category>(request);
        }

        public IEnumerable<Category> All()
        {
            var request = new SocketRequest()
            {
                EntityType = "Category",
                Method = "All"
            };

            return SocketClient.Instance.Send<IEnumerable<Category>>(request);
        }
    }
}