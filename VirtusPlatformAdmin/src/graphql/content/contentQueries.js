import gql from "graphql-tag";

export const imgById = gql`
  query imgById($id: ID!) {
    imgById(id: $id) {
      id
      url
      name
      created
    }
  }
`;
export const getAllImg = gql`
  query getAllImg($filter: GalleryFilter) {
    getAllImg(filter: $filter) {
      content {
        id
        name
        created
        url
      }
    }
  }
`;

export const videoById = gql`
  query videoById($id: ID!) {
    videoById(id: $id) {
      id
      url
      name
      title
      description
    }
  }
`;
export const getAllVideo = gql`
  query {
    getAllVideo {
      id
      name
      title
      url
      description
    }
  }
`;

export const textById = gql`
  query textById($id: ID!) {
    textById(id: $id) {
      id
      text
    }
  }
`;
