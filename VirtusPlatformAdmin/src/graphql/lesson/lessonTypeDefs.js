import gql from "graphql-tag";

export const typeDefs = gql`
  type Lesson {
    id: ID!
    title: String!
    imgUrl: String!
    module: Module!
    contents: [Content]
  }
`;
