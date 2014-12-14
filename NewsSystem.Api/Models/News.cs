namespace NewsSystem.Api.Models
{
    using System;

    public class News
    {
        public int Id { get; set; }

        public string Title { get; set; }

        public int CategoryId { get; set; }

        public DateTime Date { get; set; }

        public string Content { get; set; }
    }
}