export const resolvers = {
  Mutation: {
    newCourse: (_, { args }, { cache }) => {
      console.log("Entramos al resolver");
      const array = cache.readQuery({ query: queries.getAllCourse });
      array.getAllCourse.push(args);
      cache.writeQuery({ query: queries.getAllCourse, array });
    }
  }
};
