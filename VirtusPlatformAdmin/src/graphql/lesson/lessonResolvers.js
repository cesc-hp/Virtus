export const resolvers = {
  Mutation: {
    /*checkCursoMutation: (_, { args }, { cache }) => {
      console.log("Entramos al resolver");
      const data = cache.readQuery({
        query: queries.cursoEdit
      });
      data.name = args.name;
      cache.writeData({ data });
    }*/
  }
};
