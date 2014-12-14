namespace NewsSystem.Api.Data
{
    using System.Collections.Generic;

    public interface IRepository<T>
    {
        T Get(int id);

        IEnumerable<T> All();
    }
}
