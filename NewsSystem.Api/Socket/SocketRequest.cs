namespace NewsSystem.Api.Socket
{
    using System.Collections.Generic;
    using System.Xml.Serialization;

    public class SocketRequest
    {
        public string EntityType { get; set; }

        public string Method { get; set; }

        public IDictionary<string, object> Params { get; set; }
    }
}