import gql from "graphql-tag";

export const typeDefs = gql`
  type Module {
    id: ID!
    title: String!
    imgUrl: String!
    course: Course!
    lessons: [Lesson]
  }
`;
