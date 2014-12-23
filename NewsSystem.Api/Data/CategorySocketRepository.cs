namespace NewsSystem.Api.Data
{
    using System.Collections.Generic;
    using System.IO;
    using System.Xml.Serialization;
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

            // Send Request.
            var serializer = new XmlSerializer(typeof(SocketRequest));
            using (var writer = new StringWriter())
            {
                serializer.Serialize(writer, request);
                string a = writer.ToString();
            }

            return null;
        }

        public IEnumerable<Category> All()
        {
            var request = new SocketRequest()
            {
                EntityType = "Category",
                Method = "All"
            };

            return null;
        }
    }
}