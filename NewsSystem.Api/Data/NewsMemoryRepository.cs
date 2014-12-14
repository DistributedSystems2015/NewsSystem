namespace NewsSystem.Api.Data
{
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using NewsSystem.Api.Models;

    public class NewsMemoryRepository : IRepository<News>
    {
        private IEnumerable<News> news = new News[]
        {
            new News
            {
                Id = 1,
                Title = "Facebook престана да използва резултатите от търсене през Bing",
                CategoryId = 1,
                Date = new DateTime(2014, 12, 14, 11, 54, 0),
                Content = "Facebook вече няма да ползва резултати от търсачката Bing, след " + 
                "като по-рано тази седмица социалната мрежа стартира собствен механизъм за " + 
                "откриване на коментари и друга свързана информация. Както Facebook, така и " + 
                "Microsoft потвърдиха новината. Търсенето е изключително важно за онези 1.35 " + 
                "милиарда абонати на Facebook, които ежедневно се опитват да откриват потребители " + 
                "и всякакъв тип информация през сайта."
            },
            new News
            {
                Id = 2,
                Title = "През 2015 година се очаква стремително развитие на технологиите за безжично зареждане",
                CategoryId = 2,
                Date = new DateTime(2014, 12, 12, 15, 3, 0),
                Content = "Според експерти, през 2015 г. се очаква драстично да се увеличат решенията за " + 
                "безжично зареждане на устройства. Освен това, внедряването на технологията в сегмента на " + 
                "потребителската електроника и персоналните компютри ще се ускори със стремителни темпове."
            }
        };

        public News Get(int id)
        {
            return this.news.FirstOrDefault(item => item.Id == id);
        }

        public IEnumerable<News> All()
        {
            return this.news;
        }
    }
}