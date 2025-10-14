import gql from "graphql-tag";

export const typeDefs = gql`
  type Course {
    id: ID!
    name: String!
    description: String!
    imgUrl: String!
    modules: [Module]
  }
`;
